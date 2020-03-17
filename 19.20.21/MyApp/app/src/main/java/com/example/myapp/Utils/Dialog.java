package com.example.myapp.Utils;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class Dialog {

     public static void showErrorDialog (Context ctx, String error) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ctx);       //Создание всплывающего диалога с ошибкой, нужно передать context, чтобы было понятно из какого активити он вызван
        alert.setMessage(error);
        alert.setTitle("Ошибка!");
        alert.setCancelable(true);      //задаем возможность скрыть диалог, нажатием на пустой экран
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {       //в диалоге создается кнопка, для закрытия диалога, передаем текст, которй буте на ней и слушателя
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }      //если оставить метод пустым, диалог просто исчезнет при нажатии кнопки
        });
        //alert.setIcon() //метод позволяет задать иконку для диалога
        alert.create().show();

    }

    public static void showDialog (Context ctx, String message ) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ctx);       //Создание всплывающего диалога с ошибкой, нужно передать context, чтобы было понятно из какого активити он вызван
        alert.setMessage(message);
        alert.setCancelable(true);      //задаем возможность скрыть диалог, нажатием на пустой экран
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {       //в диалоге создается кнопка, для закрытия диалога, передаем текст, которй буте на ней и слушателя
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }      //если оставить метод пустым, диалог просто исчезнет при нажатии кнопки
        });
        //alert.setIcon() //метод позволяет задать иконку для диалога
        alert.create().show();

    }

}
