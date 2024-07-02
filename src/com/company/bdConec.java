package com.company;

import java.sql.Connection;
import java.sql.SQLException;

public class bdConec {

    public static void main(String [] args) {
        banco_functions bd = new banco_functions();
        Connection conn = bd.conect_bd("bdtot", "postgres", "1234");
         //bd.criar_mesa(conn, "employee");
        //bd.inserir_linha(conn, "Employee", "Jonas", "Brasil");
        //bd.atualizar_nome(conn, "employee", "Felipe", "Felipe Weslley");
        //bd.ler_dados(conn, "employee");
        //bd.procurar_id(conn, "employee", 3);
        //bd.deletar_linha_por_nome(conn, "employee", "Livia");
        //bd.ler_dados(conn, "employee");
        //bd.deletar_por_id(conn, "employee", 1);
        //bd.ler_dados(conn, "employee");
        bd.deletar_mesa(conn, "employee");
        }
    }


