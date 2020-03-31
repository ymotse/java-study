package estudos;

// importando os pacotes necess�rios 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

 
public class Calculadora extends JFrame implements ActionListener
{

     /**
	 * autor ISAC
	 */
	private static final long serialVersionUID = 1L;
	
	
	// variaveis do tipo JButton
     // criando os botoes para os calculos
     private JButton bt_somar;
     private JButton bt_subtrair;
     private JButton bt_multiplicar;
     private JButton bt_dividir;
     private JButton bt_ce;
     private JButton bt_back;
     private JButton bt_igual;
     private JButton bt_ponto;
     
     // criando os botoes numericos 
     private JButton bt_1;
     private JButton bt_2;
     private JButton bt_3;
     private JButton bt_4;
     private JButton bt_5;
     private JButton bt_6;
     private JButton bt_7;
     private JButton bt_8;
     private JButton bt_9;
     private JButton bt_0;
      
    //variavel do tipo JTextField
    // criando o campo onde sera inserido os valores clicados  
    private JTextField tf_calculadora;

    /* variavel do tipo JMenuBar    
       criando a barra de menu onde sera inserido o nome da nossa aplicacao */
       private JMenuBar barra_menu;
   
	/*variavel do tipo JMenu

    criando menu onde sera inserido o nome "Calculadora"  */
    private JMenu menu_calculadora;
    
    /*variavel do tipo double
    
    criando as variaveis que receberao os valore clicados e calculados   */
    private double num       = 0;
    private double resultado = 0;

    /*variavel do tipo char
     criando a variavel que recebera o comando clicado      */
    private char tecla_pressionada;
   
    // variavel do tipo boolean
    // criando uma variavel para verificar se um botao foi clicado
    private boolean click = false;
   
   
    /**
     * metodo construtor da classe Calculadora
     * @access public
     */
          
     public Calculadora()
     {
       
           setTitle("By Carlos Coelho"); // seta um t�tulo para a janela
           setSize(280,280); // seta uma dimens�o
           setLocationRelativeTo(null); // seta a posi��o
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define que a execu��o ser� finalizada quando a janela for fechada
           setResizable(false); // seta para n�o ser poss�vel redimensionar a janela
       
           // getContentPane() � um m�todo da classe JFrame que retorna um JPanel, que � o painel principal da janela
           getContentPane().setLayout(null); //informa que n�o vai usar Gerenciador de Layout

           // instancia os bot�es e atribuindo os seus nomes
           bt_somar       = new JButton("+");
           bt_multiplicar = new JButton("*");
           bt_dividir     = new JButton("/");
           bt_subtrair    = new JButton("-");
           bt_ponto       = new JButton(".");    
           bt_1           = new JButton("1");
           bt_2           = new JButton("2");
           bt_3           = new JButton("3");
           bt_4           = new JButton("4");
           bt_5           = new JButton("5");
           bt_6           = new JButton("6");
           bt_7           = new JButton("7");
           bt_8           = new JButton("8");
           bt_9           = new JButton("9");
           bt_0           = new JButton("0");
           bt_back        = new JButton("Backspace");
           bt_ce          = new JButton("ce");
           bt_igual       = new JButton("=");
           tf_calculadora = new JTextField(100);
     
           barra_menu = new JMenuBar(); // instancia a barra de menu       
           setJMenuBar(barra_menu); // seta a barra de menu na janela
           menu_calculadora   = new JMenu("Calculadora"); // instancia o menu e d� um nome
           menu_calculadora.setEnabled(false); // desativa para click
           barra_menu.add(menu_calculadora); // insere o menu na barra de menu
          
           // formatando o campo JTextField
           tf_calculadora.setHorizontalAlignment(SwingConstants.RIGHT); // seta o texto para a direita
           tf_calculadora.setText("0"); // setamos o valor zero(0), como padr�o
           tf_calculadora.setCaretPosition(1); // seta o cursor na posi��o um(1)
           tf_calculadora.setEditable(false); // evita a edi��o pelo teclado
           tf_calculadora.setBackground(Color.white); // seta um fundo branco

           // setando cores para os textos nos bot�es
           bt_1            .setForeground(Color.blue);
           bt_2            .setForeground(Color.blue);
           bt_3            .setForeground(Color.blue);
           bt_4            .setForeground(Color.blue);
           bt_5            .setForeground(Color.blue);
           bt_6            .setForeground(Color.blue);
           bt_7            .setForeground(Color.blue);
           bt_8            .setForeground(Color.blue);
           bt_9            .setForeground(Color.blue);
           bt_0            .setForeground(Color.blue);
           bt_back         .setForeground(Color.red);
           bt_ce           .setForeground(Color.red);
           bt_somar        .setForeground(Color.red);
           bt_multiplicar  .setForeground(Color.red);
           bt_subtrair     .setForeground(Color.red);
           bt_dividir      .setForeground(Color.red);
           bt_ponto        .setForeground(Color.red);
           bt_igual        .setForeground(Color.red);       

           //Posicionando os componentes na Tela
           //objeto.setBounds (posicaoColuna,posicaoLinha,comprimentodalinha,alturadalinha);    
           tf_calculadora.setBounds(20,  10,  230, 25);
           bt_back       .setBounds(20,  45,  110, 30);
           bt_ce         .setBounds(140, 45,  110, 30);      
           bt_7          .setBounds(20,  80,  50,  30);             
           bt_8          .setBounds(80,  80,  50,  30);                    
           bt_9          .setBounds(140, 80,  50,  30);             
           bt_dividir    .setBounds(200, 80,  50,  30);
           bt_4          .setBounds(20,  115, 50,  30);             
           bt_5          .setBounds(80,  115, 50,  30);                    
           bt_6          .setBounds(140, 115, 50,  30);             
           bt_multiplicar.setBounds(200, 115, 50,  30);
           bt_1          .setBounds(20,  150, 50,  30);             
           bt_2          .setBounds(80,  150, 50,  30);                    
           bt_3          .setBounds(140, 150, 50,  30);
           bt_subtrair   .setBounds(200, 150, 50,  30);
           bt_0          .setBounds(20,  185, 50,  30);
           bt_ponto      .setBounds(80,  185, 50,  30);                    
           bt_igual      .setBounds(140, 185, 50,  30);
           bt_somar      .setBounds(200, 185, 50,  30);

           // registra os bot�es ao Listener
           bt_somar      .addActionListener(this);
           bt_multiplicar.addActionListener(this);
           bt_subtrair   .addActionListener(this);
           bt_dividir    .addActionListener(this);
           bt_ponto      .addActionListener(this);
           bt_0          .addActionListener(this);
           bt_1          .addActionListener(this);      
           bt_2          .addActionListener(this);
           bt_3          .addActionListener(this);
           bt_4          .addActionListener(this);
           bt_5          .addActionListener(this);
           bt_6          .addActionListener(this);
           bt_7          .addActionListener(this);
           bt_8          .addActionListener(this);
           bt_9          .addActionListener(this);
           bt_igual      .addActionListener(this);
           bt_back       .addActionListener(this);
           bt_ce         .addActionListener(this);
       
       
           // adiciona os bot�es ao JPanel
           // getContentPane() � um m�todo da classe JFrame que retorna um JPanel, que � o painel principal da janela
           getContentPane().add(tf_calculadora);
           getContentPane().add(bt_back);
           getContentPane().add(bt_ce);
           getContentPane().add(bt_7);
           getContentPane().add(bt_8);
           getContentPane().add(bt_9);
           getContentPane().add(bt_4);
           getContentPane().add(bt_5);
           getContentPane().add(bt_6);      
           getContentPane().add(bt_1);
           getContentPane().add(bt_2);
           getContentPane().add(bt_3);        
           getContentPane().add(bt_0);
           getContentPane().add(bt_igual);        
           getContentPane().add(bt_multiplicar);
           getContentPane().add(bt_subtrair);
           getContentPane().add(bt_dividir);
           getContentPane().add(bt_somar);
           getContentPane().add(bt_ponto);
          
    }

    /**
     * m�todo para tratar eventos de click de bot�o
     * @access public
     */
    
    public void actionPerformed(ActionEvent acao)
    {
          
        // o primeiro n�mero � zero(0) e o segundo n�o � ponto ?
        if((tf_calculadora.getText().length() == 1) && (tf_calculadora.getText() .substring(0,1).equals("0")) && (!tf_calculadora.getText().substring(1,1).equals(".")))
        {
            tf_calculadora.setText(tf_calculadora.getText().replace("0",""));
        }
          
        // pressionou o bot�o ponto ?
        if(acao.getSource() == bt_ponto)
        {
            // � o segundo valor ?
            if(click)
            {
                tf_calculadora.setText(null);
               
                // tem ponto ?
                if(tf_calculadora.getText().indexOf(".") < 0)
                {
                    // � o primeiro caracter ?
                    if(tf_calculadora.getText().length() < 1)
                    {
                        tf_calculadora.setText("0.");
                    }
                    else
                    {
                        tf_calculadora.setText(".");
                    }
                }
               
            }            
            else
            {
                // tem ponto ?
                if(tf_calculadora.getText().indexOf(".") < 0)
                {
                    // � o primeiro caracter ?
                    if(tf_calculadora.getText().length() < 1)
                    {
                        tf_calculadora.setText("0.");
                    }
                    else
                    {
                        tf_calculadora.setText(tf_calculadora.getText()+".");
                    }
                }
            }
           
            click = false;
        }
          
        // pressionou o bot�o n�mero 0 ?
        if(acao.getSource() == bt_0)
        {
            // � o segundo valor ?
            if(click)
            {
                tf_calculadora.setText("0");    
            }            
            else
            {
                // o primeiro caracter � 0 ?
                if((tf_calculadora.getText().length() == 1) && (tf_calculadora.getText().equals("0")))
                {
                    tf_calculadora.setText("0");
                }
                else
                {
                    tf_calculadora.setText(tf_calculadora.getText()+"0");
                }
            }
           
            click = false;
        }
       
        // pressionou o bot�o n�mero 1 ?
        if(acao.getSource() == bt_1)
        {
            // � o segundo valor ?
            if(click)
            {
                tf_calculadora.setText("1");
            }            
            else
            {
                tf_calculadora.setText(tf_calculadora.getText()+"1");
            }
           
            click = false;
        }
       
        // pressionou o bot�o n�mero 2 ?
        if(acao.getSource() == bt_2)
        {
            // � o segundo valor ?
            if(click)
            {
                tf_calculadora.setText("2");
            }            
            else
            {
                tf_calculadora.setText(tf_calculadora.getText()+"2");
            }
           
            click = false;
        }
       
        // pressionou o bot�o n�mero 3 ?
        if(acao.getSource() == bt_3)
        {
            // � o segundo valor ?
            if(click)
            {
                tf_calculadora.setText("3");
            }            
            else
            {
                tf_calculadora.setText(tf_calculadora.getText()+"3");
            }
           
            click = false;
        }
       
        // pressionou o bot�o n�mero 4 ?        
        if(acao.getSource() == bt_4)
        {
            // � o segundo valor ?
            if(click)
            {
                tf_calculadora.setText("4");
            }            
            else
            {
                tf_calculadora.setText(tf_calculadora.getText()+"4");
            }
           
            click = false;
        }
       
        // pressionou o bot�o n�mero 5 ?
        if(acao.getSource() == bt_5)
        {
            // � o segundo valor ?
            if(click)
            {
                tf_calculadora.setText("5");
            }            
            else
            {
                tf_calculadora.setText(tf_calculadora.getText()+"5");
            }
           
            click = false;
        }
       
        // pressionou o bot�o n�mero 6 ?
        if(acao.getSource() == bt_6)
        {
            // � o segundo valor ?
            if(click)
            {
                tf_calculadora.setText("6");
            }            
            else
            {
                tf_calculadora.setText(tf_calculadora.getText()+"6");
            }
           
            click = false;
        }
       
        // pressionou o bot�o n�mero 7 ?
        if(acao.getSource() == bt_7)
        {
            // � o segundo valor ?
            if(click)
            {
                tf_calculadora.setText("7");
            }            
            else
            {
                tf_calculadora.setText(tf_calculadora.getText()+"7");
            }
           
            click = false;
        }
       
        // pressionou o bot�o n�mero 8 ?
        if(acao.getSource() == bt_8)
        {
            // � o segundo valor ?
            if(click)
            {
                tf_calculadora.setText("8");
            }            
            else
            {
                tf_calculadora.setText(tf_calculadora.getText()+"8");
            }
           
            click = false;
        }
       
        // pressionou o bot�o n�mero 9 ?
        if(acao.getSource() == bt_9)
        {
            // � o segundo valor ?
            if(click)
            {
                tf_calculadora.setText("9");
            }            
            else
            {
                tf_calculadora.setText(tf_calculadora.getText()+"9");
            }
           
            click = false;
        }
       
        // pressionou o bot�o + ?
        if(acao.getSource() == bt_somar)
           {
            click = true;
               tecla_pressionada = '+';

               num = Double.parseDouble(tf_calculadora.getText());
        }
       
        // pressionou o bot�o - ?
        if(acao.getSource() == bt_subtrair)
           {
            click = true;
               tecla_pressionada = '-';
               num = Double.parseDouble(tf_calculadora.getText());
        }
        
        // pressionou o bot�o * ?
        if(acao.getSource() == bt_multiplicar)
           {
            click = true;
               tecla_pressionada = '*';
               num = Double.parseDouble(tf_calculadora.getText());
        }
        
        // pressionou o bot�o n�mero / ?
        if(acao.getSource() == bt_dividir)
           {
            click = true;
               tecla_pressionada = '/';
               num = Double.parseDouble(tf_calculadora.getText());          
        }
        
        // pressionou o bot�o ce ?
        if(acao.getSource() == bt_ce)
        {
            num = 0;
            resultado = 0;
            click = false;
            tecla_pressionada = ' ';
            tf_calculadora.setText("0");
        }
        
        // pressionou o bot�o back ?
        if(acao.getSource() == bt_back)
        {
            // o tamanho da string � maior que zero ?
            if(tf_calculadora.getText().length() > 0)
            {
                tf_calculadora.setText(tf_calculadora.getText() .substring(0,tf_calculadora.getText().length()-1));
            }
           
            // o tamanho da string � igual a zero ?    
            if(tf_calculadora.getText().length() == 0)
            {
                tf_calculadora.setText("0");
            }
           
        }
                 
        // pressionou o bot�o = ?
           if(acao.getSource() == bt_igual)
           {  
              
            // foi o + ?
            if(tecla_pressionada == '+')
            {
                  resultado = num + Double.parseDouble(tf_calculadora.getText());
            }
           
            // foi o - ?
            if(tecla_pressionada == '-')
            {
                  resultado = num - Double.parseDouble(tf_calculadora.getText());
            }
           
            // foi o * ?
            if(tecla_pressionada == '*')
            {
                  resultado = num * Double.parseDouble(tf_calculadora.getText());
            }
           
            // foi o / ?
            if(tecla_pressionada == '/')
            {
                resultado = num / Double.parseDouble(tf_calculadora.getText());
            }
           
            // converte para string e seta o texto
               tf_calculadora.setText(String.valueOf(resultado));
            
               click = true;
           
           }
          
     }
      
     /**
      * m�todo principal da classe Calculadora
      * @access public
      */
                
     public static void main(String[] args)
     {
    
           JFrame Calc = new Calculadora(); // cria uma vari�vel do tipo Calculadora e instancia
        
           Calc.setVisible(true); // mostra a Calculadora
     }
    
}