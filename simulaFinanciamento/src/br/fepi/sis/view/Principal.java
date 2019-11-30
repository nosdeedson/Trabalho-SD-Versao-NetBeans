/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fepi.sis.view;

import br.fepi.sis.simulaFinanciamento.DadosSimulacao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import br.fepi.sis.controller.Cliente;

/**
 *
 * @author Edson
 */
public class Principal extends JFrame {

    private JPanel contentPane;
    private JTextField txtMetrosQuadradoCasa;
    private JTextField txtAnoFinanciamento;
    private JTextField txtAndares;
    private JTextField txtValor;
    private JTextField txtValorParcela;
    private JTextField txtTotalFinanciamento;
    private ButtonGroup construirComprar;

    private int metrosQuadrados, mesesFinanciamento, andares;
    private double valorCompra;
    private boolean construir;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Principal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 650, 400);
        contentPane = new JPanel();
        setResizable(false);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSimulaoFinanciamento = new JLabel("Simula\u00E7\u00E3o Financiamento");
        lblSimulaoFinanciamento.setBounds(0, 11, 644, 15);
        lblSimulaoFinanciamento.setHorizontalAlignment(SwingConstants.CENTER);
        lblSimulaoFinanciamento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        contentPane.add(lblSimulaoFinanciamento);

        JPanel panel = new JPanel();
        panel.setBounds(132, 35, 414, 135);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        JLabel lblQuantosMetrosQuadrados = new JLabel("Quantos metros quadrados? ");
        lblQuantosMetrosQuadrados.setHorizontalAlignment(SwingConstants.RIGHT);
        lblQuantosMetrosQuadrados.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel.add(lblQuantosMetrosQuadrados);

        txtMetrosQuadradoCasa = new JTextField();
        txtMetrosQuadradoCasa.setHorizontalAlignment(SwingConstants.CENTER);
        txtMetrosQuadradoCasa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel.add(txtMetrosQuadradoCasa);
        txtMetrosQuadradoCasa.setColumns(10);
        txtMetrosQuadradoCasa.requestFocus();
        txtMetrosQuadradoCasa.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                metrosQuadrados = Integer.parseInt(txtMetrosQuadradoCasa.getText());
            }

        });

        JLabel lblMesFinanciamento = new JLabel("Quantos meses  de financiamento? ");
        lblMesFinanciamento.setVerticalAlignment(SwingConstants.BOTTOM);
        lblMesFinanciamento.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMesFinanciamento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel.add(lblMesFinanciamento);

        txtAnoFinanciamento = new JTextField();
        txtAnoFinanciamento.setHorizontalAlignment(SwingConstants.CENTER);
        txtAnoFinanciamento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel.add(txtAnoFinanciamento);
        txtAnoFinanciamento.setColumns(10);
        txtAnoFinanciamento.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                mesesFinanciamento = Integer.parseInt(txtAnoFinanciamento.getText());
            }

        });

        JLabel lblAndares = new JLabel("Quantos andares?");
        lblAndares.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAndares.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel.add(lblAndares);

        txtAndares = new JTextField();
        txtAndares.setHorizontalAlignment(SwingConstants.CENTER);
        txtAndares.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel.add(txtAndares);
        txtAndares.setColumns(10);

        txtAndares.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e); //To change body of generated methods, choose Tools | Templates.
                andares = Integer.parseInt(txtAndares.getText());
            }

        });

        construirComprar = new ButtonGroup();

        JRadioButton rdbtnConstruir = new JRadioButton("Construir");
        rdbtnConstruir.setHorizontalAlignment(SwingConstants.RIGHT);
        rdbtnConstruir.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel.add(rdbtnConstruir);
        rdbtnConstruir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                // TODO Auto-generated method stub
                super.mouseClicked(arg0);
                construir = true;
                valorCompra = 0.0;
            }
        });

        construirComprar.add(rdbtnConstruir);

        JRadioButton rdbtnComprar = new JRadioButton("Comprar");
        rdbtnComprar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel.add(rdbtnComprar);
        rdbtnComprar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                // TODO Auto-generated method stub
                super.mouseClicked(arg0);
                txtValor.setEditable(true);
                txtValor.setEnabled(true);
                construir = false;

            }
        });

        construirComprar.add(rdbtnComprar);

        JLabel lblValor = new JLabel("Valor?");
        lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
        lblValor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel.add(lblValor);

        txtValor = new JTextField();
        txtValor.setEnabled(false);
        txtValor.setEditable(false);
        txtValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtValor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel.add(txtValor);
        txtValor.setColumns(10);
        txtValor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseClicked(e);
                if (construir) {
                    JOptionPane.showMessageDialog(null, "Como � constru��o o sistema calcula valor!!");
                } 
            }
        });
        txtValor.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                super.focusLost(e);
                valorCompra = Double.parseDouble(txtValor.getText());
            }
        });
        JButton btnEnviar = new JButton("Enviar");
        //btnEnviar.setBackground(UIManager.getColor("Button.focus"));
        btnEnviar.setBackground(SystemColor.menu);
        btnEnviar.setBounds(270, 181, 100, 20);
        contentPane.add(btnEnviar);
        btnEnviar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        
        btnEnviar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mousePressed(e);
                if (construir) {
                    DadosSimulacao dados = new DadosSimulacao();
                    dados.setAndares(andares);
                    dados.setConstruirCasa(construir);
                    dados.setMesesFinanciamento(mesesFinanciamento);
                    dados.setMetrosQuadradosCasa(metrosQuadrados);
                    dados.setValorImovel(0.0);
                    Cliente cli = new Cliente();
                    double valorFinanciamento = cli.chamadaRemota(dados);
                    DecimalFormat df = new DecimalFormat();
                    df.applyPattern("R$ #,##0.00");
                    //txtTotalFinanciamento.setText(Double.toString(valorFinanciamento));
                    txtTotalFinanciamento.setText(df.format(valorFinanciamento));
                    txtValorParcela.setText(df.format(valorFinanciamento / mesesFinanciamento));
                    txtAndares.setText("");
                    txtAnoFinanciamento.setText("");
                    txtMetrosQuadradoCasa.setText("");
                } else {
                    DadosSimulacao dados = new DadosSimulacao();
                    dados.setAndares(andares);
                    dados.setConstruirCasa(construir);
                    dados.setMesesFinanciamento(mesesFinanciamento);
                    dados.setMetrosQuadradosCasa(metrosQuadrados);
                    dados.setValorImovel(Double.parseDouble(txtValor.getText()));
                    Cliente cli = new Cliente();
                    double valorFinanciamento = cli.chamadaRemota(dados);
                    DecimalFormat df = new DecimalFormat();
                    df.applyPattern("R$ #,##0.00");
                    //txtTotalFinanciamento.setText(Double.toString(valorFinanciamento));
                    txtTotalFinanciamento.setText(df.format(valorFinanciamento));
                    txtValorParcela.setText(df.format(valorFinanciamento / mesesFinanciamento));
                    txtAndares.setText("");
                    txtAnoFinanciamento.setText("");
                    txtMetrosQuadradoCasa.setText("");
                }
            }
        });
		// abaixo dados da resposta do servidor

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(132, 242, 414, 51);
        contentPane.add(panel_1);
        panel_1.setLayout(new GridLayout(2, 2, 5, 5));

        JLabel lblValorDaParcela = new JLabel("Valor da Parcela");
        lblValorDaParcela.setHorizontalAlignment(SwingConstants.RIGHT);
        lblValorDaParcela.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel_1.add(lblValorDaParcela);

        txtValorParcela = new JTextField();
        txtValorParcela.setHorizontalAlignment(SwingConstants.CENTER);
        txtValorParcela.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel_1.add(txtValorParcela);
        txtValorParcela.setColumns(10);

        JLabel lblValorFianciamento = new JLabel("Valor Financiamento:");
        lblValorFianciamento.setHorizontalAlignment(SwingConstants.RIGHT);
        lblValorFianciamento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel_1.add(lblValorFianciamento);

        txtTotalFinanciamento = new JTextField();
        txtTotalFinanciamento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        txtTotalFinanciamento.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(txtTotalFinanciamento);
        txtTotalFinanciamento.setColumns(10);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(252, 315, 89, 23);
        contentPane.add(btnLimpar);
        btnLimpar.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
                txtTotalFinanciamento.setText("");
                txtValorParcela.setText("");
                txtValor.setText("");
                txtValor.setEditable(false);
                txtValor.setEnabled(false);
                construirComprar.clearSelection();
            }

        });
    }
}
