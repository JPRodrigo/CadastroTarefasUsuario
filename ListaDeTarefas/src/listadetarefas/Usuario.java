
package listadetarefas;

import java.util.ArrayList;

public class Usuario {
   private String email;
   private String senha;
   private ArrayList<Tarefa> tarefa;   
   

    public ArrayList<Tarefa> getTarefa() {
        return tarefa;
    }

    public void setTarefa(ArrayList<Tarefa> tarefa) {
        this.tarefa = tarefa;
    }
   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
   
}
