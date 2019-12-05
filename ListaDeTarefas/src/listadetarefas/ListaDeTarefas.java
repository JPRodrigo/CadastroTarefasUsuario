package listadetarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefas {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Usuario> arryU = new ArrayList();
        ArrayList<Tarefa> arryT = new ArrayList();

        boolean menu1 = false;
        boolean menu2 = false;

        while (!menu1) {

            /* 1º Menu */
            System.out.println("=========== Menu 01 ================");
            System.out.println("01 - Fazer Cadastro");
            System.out.println("02 - Fazer Login");
            System.out.println("03 - Encerra Program");
            System.out.println("====================================");
            // pergunta 
            System.out.println("Digite a opção desejada: ");
            String valorMenu1 = scan.nextLine(); // valor recebido

            switch (valorMenu1) {

                case "1"://faze cadastro
                    System.out.println("Digite E-mail");
                    String email = scan.nextLine();

                    System.out.println("Digite Senha");
                    String senha = scan.nextLine();

                    Usuario u = new Usuario();
                    u.setEmail(email);
                    u.setSenha(senha);
                    arryU.add(u);

                    break;
                case "2":// fazer login
                    boolean valida = false;
                    while (!valida) {

                        System.out.println("++++++++++Login+++++++++++");
                        System.out.print("Digite o email: ");
                        String verificaEmail = scan.nextLine();
                        System.out.print("Digite Senha: ");
                        String verificaSenha = scan.nextLine();
                        System.out.println("++++++++++++++++++++++++++");

                        for (int i = 0; i < arryU.size(); i++) {

                            if (verificaEmail.equals(arryU.get(i).getEmail())
                                    && verificaSenha.equals(arryU.get(i).getSenha())) {
                                System.out.println("Usuario logado com sucesso");
                                valida = true;
                                menu2 = true;

                            } else {
                                System.out.println("Email ou senha invalido");
                                System.out.println("Deseja fazer nova tentativa s/n");
                                char nTentativa = scan.nextLine().charAt(0);
                                if (nTentativa == 'n') {
                                    valida = true;
                                }
                            }
                        }

                    }

                    break;
                case "3"://finaliza programa
                    System.out.println("Programa Finalizado");
                    menu1 = true;
                    break;
                default:
                    System.out.println(" Erro (Valor Digitado é Invalido)");
            }

            while (menu2) {
                System.out.println("=========== Menu 02 ================");
                System.out.println("01 - Mostra toda as tarefas");
                System.out.println("02 - Mostra tarefas Finalizadas");
                System.out.println("03 - Mostra tarefas Não finalizadas");
                System.out.println("04 - Adicionar nova tarefa");
                System.out.println("05 - Finaliza Tarefa");
                System.out.println("06 - Remove Tarefa");
                System.out.println("07 - Fazer Logout");
                System.out.println("====================================");
                String valorMenu2 = scan.nextLine();

                switch (valorMenu2) {
                    case "1":// Mostra toda as tarefas
                        System.out.println("//////////////////////////////");
                        System.out.println(" Todas as tarefas do Usuario :");
                        for (int i = 0; i < arryT.size(); i++) {
                            System.out.println("Tarefa: " + (i + 1));
                            System.out.println("Titulo: " + arryT.get(i).getTitulo());
                            System.out.println("Finalizada:" + arryT.get(i).isFinalizada());
                        }
                        menu2 = true;
                        break;

                    case "2":// Mostra tarefas Finalizadas
                        System.out.println(" Tarefas Finalizadas");
                        for (int i = 0; i < arryT.size(); i++) {
                            if (arryT.get(i).isFinalizada() == false) {
                                System.out.println("Tarefa: " + (i + 1));
                                System.out.println("Titulo: " + arryT.get(i).getTitulo());
                                System.out.println("Finalizada:" + arryT.get(i).isFinalizada());
                            }
                        }
                        break;

                    case "3":// Mostra tarefas Não finalizadas

                        System.out.println(" Tarefas não Finalizadas");
                        for (int i = 0; i < arryT.size(); i++) {
                            if (arryT.get(i).isFinalizada() == true) {
                                System.out.println("Tarefa: " + (i + 1));
                                System.out.println("Titulo: " + arryT.get(i).getTitulo());
                                System.out.println("Finalizada:" + arryT.get(i).isFinalizada());
                            }
                        }
                        break;

                    case "4":// Adicionar nova tarefa
                        System.out.println("//////////////////");
                        System.out.println(" Adicionar Tarefa");
                        System.out.println("Digite o titulo da tarefa ");
                        String titulo = scan.nextLine();

                        Tarefa t = new Tarefa();
                        t.setTitulo(titulo);
                        t.setFinalizada(true);

                        arryT.add(t);

                        break;
                    case "5":// Finaliza Tarefa

                        System.out.println(" Finaliza tarefa ");
                        for (int i = 0; i < arryT.size(); i++) {
                            if (arryT.get(i).isFinalizada()==true) {
                                System.out.println("Tarefa: " + (i + 1));
                                System.out.println("Titulo: " + arryT.get(i).getTitulo());
                                System.out.println("Finalizada:" + arryT.get(i).isFinalizada());
                            }
                        }
                        System.out.println("Qual tarefa deseja Finaliza digite o numero da tarefa");
                        int finali = scan.nextInt();
                        scan.nextLine();
                        finali--;

                        arryT.get(finali).setFinalizada(false);
                        System.out.println("Tarefa Finalizada com sucesso");

                        break;
                    case "6":// Remove Tarefa

                        System.out.println(" Remove tarefas");

                        for (int i = 0; i < arryT.size(); i++) {

                            System.out.println("Tarefa: " + (i + 1));
                            System.out.println("Titulo: " + arryT.get(i).getTitulo());
                            System.out.println("Finalizada:" + arryT.get(i).isFinalizada());
                        }
                        System.out.println("Qual tarefa deseja remover digite o numero da tarefa");
                        int num = scan.nextInt();
                        scan.nextLine();
                        num--;

                        arryT.remove(num).getTitulo();
                        System.out.println("Tarefa Removida com sucesso");
                        
                        break;
                    case "7":// Fazer Logout

                        menu2 = false;
                        break;
                    default:
                        System.out.println(" Erro (Valor Digitado é Invalido)");
                }
            }
        }
    }
}
