package ru.skypro;

import ru.skypro.exception.WrongLoginException;
import ru.skypro.exception.WrongPasswordException;

public class Main {

    public static void main(String[] args) {
        String login = "1qaz";
        String pass = "2wsx";
        String confirmPass = "2wsx";

        if(Authorization(login, pass, confirmPass)){
            System.out.println("Успешное выполнение");
        };

    }


    public static boolean Authorization(String login, String pass, String confirmPass)
    {
        try {
            return checkLogin(login) && checkPass(pass,confirmPass);
        } catch (WrongLoginException ex){
            System.out.println(ex.getMessage());
            return false;
        } catch (WrongPasswordException ex){
            System.out.println(ex.getMessage());
            return false;
        }

    }

    private  static boolean checkLogin(String login)
    {
        if(login == null){
            System.out.println("Логин не может быть пустым!");
            return false;
        }

        if(!login.matches("^[A-Za-z0-9]+$")){
            System.out.println("Недопустимые символы  в логине");
            return false;
        }

        if(login.length()>20){
            throw new WrongLoginException("Слишком длинный логин");
        }
        return true;

    }

    private static boolean checkPass(String pass, String confirmPass)
    {
        if(pass == null){
            System.out.println("Пароль не может быть пустым");
            return false;
        }

        if(confirmPass == null){
            System.out.println("Подтверждение пароля не может быть пустым");
            return false;
        }

        if(!pass.equals(confirmPass)){
            throw new WrongPasswordException("Пароли не совпадают");
        }

        if(!pass.matches("^[A-Za-z0-9]+$")){
            System.out.println("Недопустимые символы");
            return false;
        }

        if(pass.length()>20){
            System.out.println("Слишком длинный пароль");
            return false;
        }
        return true;
    }
}
