package Controller;

import Model.ModelPessoa;
import View.View;
import View.ViewLogin;
import View.ViewPrincipal;
import View.ViewSelect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author dklug
 */
public class ControllerLogin {
    private ViewLogin viewLogin;
    private View view;
    private ViewSelect viewSelect;
    private String user;

    public ControllerLogin(View view, ViewSelect viewSelect, String user) {
        ViewLogin viewLogin = new ViewLogin();
        this.viewLogin = viewLogin;
        this.view = view;
        this.viewSelect = viewSelect;
        this.user = user;
        this.iniciaBotoes();
    }
    
    public void iniciaBotoes() {
        this.viewLogin.adicionaAcaoBotaoEntrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }
    
    public void exibir() {
        this.viewLogin.setVisible(true);
    }
    
    public void fecharTela() {
        this.viewLogin.dispose();
    }
    
    public void login() {
        SenhaRepository repository = new SenhaRepository();
        String senhaDigitada = new String(this.viewLogin.getCampoSenha());
        if(senhaDigitada != null) {
            if(repository.autentica(senhaDigitada)) {
               this.fecharTela();
               this.viewSelect.dispose();
               this.redireciona();
            } else {
                this.viewLogin.exibeMensagem("Senha incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
                this.viewLogin.setCampoSenha("");
            }
        } else {
            this.viewLogin.exibeMensagem("Nenhuma senha informada", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void redireciona() {
        if(this.user.equals("Driver")){
            ViewPrincipal view = new ViewPrincipal(this.view, ModelPessoa.DRIVER);
            view.setVisible(true);
            this.fecharTela();
        } else if(this.user.equals("Admin")){
            ViewPrincipal view = new ViewPrincipal(this.view, ModelPessoa.ADMIN);
            view.setVisible(true);
            this.fecharTela();
        }
    }
}
