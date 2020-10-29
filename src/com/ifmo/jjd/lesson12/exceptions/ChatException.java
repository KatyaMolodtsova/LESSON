package com.ifmo.jjd.lesson12.exceptions;
// если необходимо создать собственный класс
// исключения времени выполнения, то класс
// должен наследоваться от RuntimeException

// если необходимо создать собственный класс
// исключения времени компиляции, то класс
// должен наследоваться от Exception
public class ChatException extends Exception{

    public ChatException(String message) {
        super(message);
    }

    public ChatException(String message, Throwable cause) {
        super(message, cause);
    }

    // можем переопределять методы родителя
    @Override
    public String getMessage() {
        return super.getMessage() + " Будьте внимательны";
    }
}
