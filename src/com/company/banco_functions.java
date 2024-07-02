package com.company;
import java.lang.reflect.Executable;
import java.sql.*;
import java.util.Scanner;

public class banco_functions{
    public Connection conect_bd(String dbname, String user, String pass){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/" + dbname;
            conn = DriverManager.getConnection(url, user, pass);
            if (conn!=null){
                System.out.println("Conexão concluida");
            }else{
                System.out.println("Falha na conexão");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer conexão: " + e.getMessage());
        }
        return conn;
    }

    public void criar_mesa(Connection conn, String nome_mesa){
        Statement statement;
            try{
                String query = "CREATE TABLE " + nome_mesa + "(empid SERIAL, name varchar(200), address varchar(200), primary key (empid))";
                statement = conn.createStatement();
                statement.executeUpdate(query);
                System.out.println("Tabela criada com sucesso! " + nome_mesa);
            }catch (Exception e) {
                System.out.println(e);
                }
            }

        public void inserir_linha(Connection conn, String nome_mesa, String name, String address){
                Statement statement = null;
                    try{
                        String query = String.format("insert into %s(name,address) values ('%s', '%s');", nome_mesa, name, address);
                        statement = conn.createStatement();
                        statement.executeUpdate(query);
                        System.out.println("Linha inserida com sucesso! ");
                    }catch (Exception e){
                        System.out.println(e);
                    }
        }

        public void ler_dados(Connection conn, String nome_mesa){
            Statement statement;
            ResultSet rs = null;

                 try{
                    String query = String.format("select * from %s", nome_mesa);
                    statement = conn.createStatement();
                    rs = statement.executeQuery(query);
                        while(rs.next()){
                            System.out.print(rs.getString("empid")+ " ");
                            System.out.print(rs.getString("name")+ " ");
                            System.out.println(rs.getString("address")+ " ");
                        }
                 }catch (Exception e){
                    System.out.println(e);

                }
        }
        public void atualizar_nome(Connection conn,String nome_mesa, String old_name, String new_name){
            Statement statement;
            try{
                String query = String.format("update %s set name = '%s' where name= '%s'", nome_mesa, new_name, old_name);
                statement = conn.createStatement();
                statement.executeUpdate(query);
                System.out.println("Dados atualizados! ");
            }catch(Exception e){
                System.out.println(e);

            }
        }
        public void procurar_nome(Connection conn, String nome_mesa, String nome){
            Statement statement;
            ResultSet rs = null;

                try{
                    String query = String.format("select * from %s where name = '%s'", nome_mesa, nome);
                    statement = conn.createStatement();
                    rs = statement.executeQuery(query);
                        while (rs.next()){
                            System.out.print(rs.getString("empid") + " ");
                            System.out.print(rs.getString("name")+ " ");
                            System.out.println(rs.getString("address")+ " ");

                        }
                    System.out.println("Busca concluida! ");
                }catch (Exception e){
                    System.out.println(e);
                }


        }
        public void procurar_id(Connection conn, String nome_mesa, int empid){
            Scanner scan = new Scanner(System.in);
            Statement statement;
            ResultSet rs = null;

                try{

                    String query = String.format("select * from %s where empid = %s " , nome_mesa, empid);
                    statement = conn.createStatement();
                    rs = statement.executeQuery(query);
                    while(rs.next()){
                        System.out.println(rs.getString("empid") + " ");
                        System.out.println(rs.getString("name") + " ");
                        System.out.println(rs.getString("address") + " ");
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
        }

        public void deletar_linha_por_nome(Connection conn, String nome_mesa, String nome){
                Statement statement;

                    try{
                        String query = String.format("delete from %s where name = '%s'",nome_mesa,nome);
                        statement=conn.createStatement();
                        statement.executeUpdate(query);
                        System.out.println("Dados deletados com sucesso! ");

                    }catch (Exception e){
                        System.out.println(e);
                    }
        }
        public void deletar_por_id(Connection conn, String nome_mesa, int empid){
                Statement statement;

                try{
                    String query = String.format("delete from %s where empid = '%s'", nome_mesa, empid);
                    statement = conn.createStatement();
                    statement.executeUpdate(query);
                    System.out.println("Id deletado com sucesso!");
                }catch (Exception e){
                    System.out.println(e);
                }
        }
        public void deletar_mesa(Connection conn, String nome_mesa){
            Statement statement;
                try{
                    String query = String.format("drop table %s", nome_mesa);
                    statement = conn.createStatement();
                    statement.executeUpdate(query);
                    System.out.println("Mesa deletada com sucesso! ");
                }catch (Exception e){
                    System.out.println(e);
                }
        }



}

