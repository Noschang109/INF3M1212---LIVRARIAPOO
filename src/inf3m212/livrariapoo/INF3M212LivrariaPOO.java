/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf3m212.livrariapoo;

import controller.CCliente;
import controller.CEditora;
import controller.CLivro;
import controller.CVendaLivro;
import util.Validadores;
import java.util.Scanner;
import model.Cliente;

/**
 *
 * @author jbferraz
 */
public class INF3M212LivrariaPOO {

    public static CCliente cadCliente = new CCliente();
    public static CEditora cadEditora = new CEditora();
    public static CLivro cadLivro = new CLivro();
    public static CVendaLivro cadVendaLivro = new CVendaLivro();
    public static Scanner leia = new Scanner(System.in);

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        int num = 99;
        try {
            num = leiaNum.nextInt();
        } catch (Exception e) {
            System.out.println("Tente novamente!");
            leiaNum.nextLine();
        }
        return num;
    }

    public static void menuP() {
        System.out.println(".: Livraria :.");
        System.out.println("1 - Ger. Clientes");
        System.out.println("2 - Ger. Editoras");
        System.out.println("3 - Ger. Livros");
        System.out.println("4 - Venda Livro");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void subMenu(int op) {
        String tpCad = null;
        switch (op) {
            case 1:
                tpCad = "Cliente";
                break;
            case 2:
                tpCad = "Editora";
                break;
            case 3:
                tpCad = "Livro";
                break;
        }
        System.out.println(".: Ger. " + tpCad + " :.");
        System.out.println("1 - Cadastrar " + tpCad);
        System.out.println("2 - Editar " + tpCad);
        System.out.println("3 - Listar " + tpCad + "s");
        System.out.println("4 - Deletar " + tpCad);
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarCliente() {
        int idCliente;
        String nomeCliente;
        String cpf;
        String cnpj = null;
        String endereco;
        String telefone;

        System.out.println("-- Cadastro de Cliente --");
        System.out.print("Informe o CPF: ");
        boolean cpfIs;
        int opCPF;
        do {
            cpf = leia.nextLine();
            cpfIs = Validadores.isCPF(cpf);
            if (!cpfIs) {
                System.out.println("CPF inválido!"
                        + "\nDeseja tentar novamente? 1 - Sim | 2 - Não");
                opCPF = leiaNumInt();
                if (opCPF == 1) {
                    System.out.print("Informe o CPF: ");
                } else if (opCPF == 2) {
                    System.out.println("Cadastro cancelado pelo usuário!");
                    break;
                }
            }
        } while (!cpfIs);
        if (cadCliente.getClienteCPF(cpf) != null) {
            System.out.println("Cliente já cadastrado!");
        } else {
            System.out.print("Informe o nome: ");
            nomeCliente = leia.nextLine();
            System.out.print("Informe o telefone: ");
            telefone = leia.nextLine();
            System.out.print("Informe o endereço: ");
            endereco = leia.nextLine();
            idCliente = cadCliente.geraID();
            Cliente cli = new Cliente(idCliente, nomeCliente, cpf,
                    cnpj, endereco, telefone);
            cadCliente.addCliente(cli);
            System.out.println("Cliente cadastrado com sucesso!");
        }
    }//fim cadastrarCliente

    public static void deletarCliente() {
        System.out.println("-- Deletar Cliente --");
        System.out.print("Informe o cpf: ");
        String cpf = leia.next();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = cadCliente.getClienteCPF(cpf);
            if (cli != null) {
                cadCliente.removeCliente(cli);
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Cliente não consta na base de dados!");
            }
        } else {
            System.out.println("CPF inválido!");
        }
    }//fim deletarCliente

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cadCliente.mockClientes();
        cadEditora.mockEditoras();
        cadLivro.mockLivros();
        cadVendaLivro.mockVendaLivros();
        int opM;

        do {
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                case 3:
                    int opSM;
                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:
                                System.out.println("-- Cadastrar --");
                                //usar opM pra definir qual cadastro
                                cadastrarCliente();
                                break;
                            case 2:
                                System.out.println("-- Editar --");
                                editarCliente();
                                break;
                            case 3:
                                System.out.println("-- Listar --");
                                listarClientes();
                                break;
                            case 4:
                                System.out.println("-- Deletar --");
                                deletarCliente();
                                break;
                            case 0:
                                System.out.println("-- Menu Principal --");
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!");
                                break;
                        }
                    } while (opSM != 0);//fim subMenu
                    break;
                case 4:
                    System.out.println("-- Venda Livro --");
                    break;
                case 0:
                    System.out.println("Aplicação encerrada pelo usuário!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        } while (opM != 0);//fim Sistema

    }

    private static void listarClientes() {
        for (Cliente cli : cadCliente.getClientes()) {
            System.out.println("---");
            System.out.println("CPF:\t" + cli.getCpf());
            System.out.println("Nome:\t" + cli.getNomeCliente());
            System.out.println("Fone:\t" + cli.getTelefone());
        }
    }

    private static void editarCliente() {
        System.out.println("-- Editar Cliente --");
        System.out.print("Informe o CPF: ");
        String cpf = leia.nextLine();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = cadCliente.getClienteCPF(cpf);
            if (cli != null) {
                System.out.println("1 - Nome:\t" + cli.getNomeCliente());
                System.out.println("2 - Endereço:\t" + cli.getEndereco());
                System.out.println("3 - Fone:\t" + cli.getTelefone());
                System.out.println("4 - Todos os campos acima?");
                System.out.print("Qual campo deseja alterar?"
                        + "\nDigite aqui: ");
                int opEditar = leiaNumInt();
                //Sugestão Sérgio INF3M212
                if (opEditar == 1 || opEditar == 4) {// "||" pipe significa "ou"
                    System.out.print("Informe o nome: ");
                    cli.setNomeCliente(leia.nextLine());
                }
                if (opEditar == 2 || opEditar == 4) {
                    System.out.print("Informe o endereço: ");
                    cli.setEndereco(leia.nextLine());
                }
                if (opEditar == 3 || opEditar == 4) {
                    System.out.print("Informe o telefone: ");
                    cli.setTelefone(leia.nextLine());
                }
                if (opEditar < 1 || opEditar > 4) {
                    System.out.println("Opção inválida!");
                }
                /*
                switch (opEditar) {
                    case 1:
                        System.out.print("Informe o nome: ");
                        cli.setNomeCliente(leia.nextLine());
                        break;
                    case 2:
                        System.out.print("Informe o endereço: ");
                        cli.setEndereco(leia.nextLine());
                        break;
                    case 3:
                        System.out.print("Informe o telefone: ");
                        cli.setTelefone(leia.nextLine());
                        break;
                    case 4:
                        System.out.println("Informe todos os campos abaixo:");
                        System.out.print("Informe o nome: ");
                        cli.setNomeCliente(leia.nextLine());
                        System.out.print("Informe o endereço: ");
                        cli.setEndereco(leia.nextLine());
                        System.out.print("Informe o telefone: ");
                        cli.setTelefone(leia.nextLine());
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                 */
                System.out.println("Cliente:\n" + cli.toString());
            } else {
                System.out.println("Cliente não cadastrado!");
            }
        } else {
            System.out.println("CPF inválido!");
        }
    }

}
