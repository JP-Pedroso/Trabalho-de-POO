package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SistemaUniversidadeGUI extends JFrame {
    private SistemaUniversidadeController controller;
    private JTextArea outputArea;
    private JScrollPane scrollPane;
    
    public SistemaUniversidadeGUI() {
        controller = new SistemaUniversidadeController();
        initializeGUI();
    }
    
    private void initializeGUI() {
        setTitle("Sistema de Gestão Universitária - FCT/UNESP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Painel de botões (lado esquerdo)
        JPanel buttonPanel = createButtonPanel();
        
        // Área de saída (lado direito)
        outputArea = new JTextArea(25, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        scrollPane = new JScrollPane(outputArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        // Adicionando componentes ao painel principal
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(mainPanel);
        
        // Configurações finais da janela
        pack();
        setLocationRelativeTo(null);
        setResizable(true);
        
        // Mensagem inicial
        outputArea.setText("Sistema de Gestão Universitária - FCT/UNESP\n" +
                          "Selecione uma opção do menu lateral para começar.\n\n");
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Menu de Opções"));
        panel.setPreferredSize(new Dimension(250, 600));
        
        // Seção de Cadastros
        panel.add(createSectionLabel("CADASTROS"));
        panel.add(createButton("Cadastrar Departamento", e -> cadastrarDepartamento()));
        panel.add(createButton("Cadastrar Técnico", e -> cadastrarTecnico()));
        panel.add(createButton("Cadastrar Docente Efetivo", e -> cadastrarDocenteEfetivo()));
        panel.add(createButton("Cadastrar Docente Substituto", e -> cadastrarDocenteSubstituto()));
        
        panel.add(Box.createVerticalStrut(10));
        
        // Seção de Relatórios
        panel.add(createSectionLabel("RELATÓRIOS"));
        panel.add(createButton("Relatório Geral", e -> gerarRelatorioGeral()));
        panel.add(createButton("Resumo Departamentos", e -> gerarResumoDepartamentos()));
        panel.add(createButton("Departamentos por Faixa", e -> departamentosPorFaixa()));
        panel.add(createButton("Funcionários por Salário", e -> funcionariosPorSalario()));
        
        panel.add(Box.createVerticalStrut(10));
        
        // Seção de Consultas por Categoria
        panel.add(createSectionLabel("CONSULTAS POR CATEGORIA"));
        panel.add(createButton("Todos os Funcionários", e -> todosFuncionarios()));
        panel.add(createButton("Todos os Técnicos", e -> todosTecnicos()));
        panel.add(createButton("Todos os Docentes", e -> todosDocentes()));
        panel.add(createButton("Docentes Efetivos", e -> docentesEfetivos()));
        panel.add(createButton("Docentes Substitutos", e -> docentesSubstitutos()));
        
        panel.add(Box.createVerticalStrut(10));
        
        // Seção de Buscas
        panel.add(createSectionLabel("BUSCAS"));
        panel.add(createButton("Buscar por Código", e -> buscarPorCodigo()));
        panel.add(createButton("Buscar por Nome", e -> buscarPorNome()));
        panel.add(createButton("Info. Departamento", e -> infoDepartamento()));
        
        panel.add(Box.createVerticalStrut(10));
        
        // Botão para limpar a tela
        panel.add(createButton("Limpar Tela", e -> outputArea.setText("")));
        
        return panel;
    }
    
    private JLabel createSectionLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }
    
    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(230, 30));
        button.addActionListener(listener);
        return button;
    }
    
    // Métodos de cadastro
    private void cadastrarDepartamento() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        JTextField codigoField = new JTextField();
        JTextField nomeField = new JTextField();
        
        panel.add(new JLabel("Código:"));
        panel.add(codigoField);
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        
        int result = JOptionPane.showConfirmDialog(this, panel, 
                    "Cadastrar Departamento", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            String codigo = codigoField.getText().trim();
            String nome = nomeField.getText().trim();
            
            if (!codigo.isEmpty() && !nome.isEmpty()) {
                if (controller.adicionarDepartamento(codigo, nome)) {
                    outputArea.append("Departamento cadastrado com sucesso!\n");
                    outputArea.append("Código: " + codigo + ", Nome: " + nome + "\n\n");
                } else {
                    outputArea.append("Erro ao cadastrar departamento.\n\n");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
            }
        }
    }
    
    private void cadastrarTecnico() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        JTextField codigoDeptField = new JTextField();
        JTextField codigoField = new JTextField();
        JTextField nomeField = new JTextField();
        JTextField salarioField = new JTextField();
        JComboBox<String> nivelCombo = new JComboBox<>(controller.getNiveisTecnico());
        JComboBox<String> funcaoCombo = new JComboBox<>(controller.getFuncoesTecnico());
        
        panel.add(new JLabel("Código do Departamento:"));
        panel.add(codigoDeptField);
        panel.add(new JLabel("Código do Funcionário:"));
        panel.add(codigoField);
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Salário Base:"));
        panel.add(salarioField);
        panel.add(new JLabel("Nível:"));
        panel.add(nivelCombo);
        panel.add(new JLabel("Função:"));
        panel.add(funcaoCombo);
        
        int result = JOptionPane.showConfirmDialog(this, panel, 
                    "Cadastrar Técnico", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                String codigoDept = codigoDeptField.getText().trim();
                String codigo = codigoField.getText().trim();
                String nome = nomeField.getText().trim();
                double salario = Double.parseDouble(salarioField.getText().trim());
                String nivel = (String) nivelCombo.getSelectedItem();
                String funcao = (String) funcaoCombo.getSelectedItem();
                
                if (controller.adicionarTecnico(codigoDept, codigo, nome, salario, nivel, funcao)) {
                    outputArea.append("Técnico cadastrado com sucesso!\n");
                    outputArea.append("Nome: " + nome + ", Código: " + codigo + "\n\n");
                } else {
                    outputArea.append("Erro ao cadastrar técnico. Verifique se o departamento existe.\n\n");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Valor de salário inválido!");
            }
        }
    }
    
    private void cadastrarDocenteEfetivo() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        JTextField codigoDeptField = new JTextField();
        JTextField codigoField = new JTextField();
        JTextField nomeField = new JTextField();
        JTextField salarioField = new JTextField();
        JComboBox<String> nivelCombo = new JComboBox<>(controller.getNiveisDocente());
        JComboBox<String> titulacaoCombo = new JComboBox<>(controller.getTitulacoes());
        JComboBox<String> areaCombo = new JComboBox<>(controller.getAreas());
        
        panel.add(new JLabel("Código do Departamento:"));
        panel.add(codigoDeptField);
        panel.add(new JLabel("Código do Funcionário:"));
        panel.add(codigoField);
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Salário Base:"));
        panel.add(salarioField);
        panel.add(new JLabel("Nível:"));
        panel.add(nivelCombo);
        panel.add(new JLabel("Titulação:"));
        panel.add(titulacaoCombo);
        panel.add(new JLabel("Área:"));
        panel.add(areaCombo);
        
        int result = JOptionPane.showConfirmDialog(this, panel, 
                    "Cadastrar Docente Efetivo", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                String codigoDept = codigoDeptField.getText().trim();
                String codigo = codigoField.getText().trim();
                String nome = nomeField.getText().trim();
                double salario = Double.parseDouble(salarioField.getText().trim());
                String nivel = (String) nivelCombo.getSelectedItem();
                String titulacao = (String) titulacaoCombo.getSelectedItem();
                String area = (String) areaCombo.getSelectedItem();
                
                if (controller.adicionarDocenteEfetivo(codigoDept, codigo, nome, salario, nivel, titulacao, area)) {
                    outputArea.append("Docente Efetivo cadastrado com sucesso!\n");
                    outputArea.append("Nome: " + nome + ", Código: " + codigo + "\n\n");
                } else {
                    outputArea.append("Erro ao cadastrar docente efetivo. Verifique se o departamento existe.\n\n");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Valor de salário inválido!");
            }
        }
    }
    
    private void cadastrarDocenteSubstituto() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        JTextField codigoDeptField = new JTextField();
        JTextField codigoField = new JTextField();
        JTextField nomeField = new JTextField();
        JTextField salarioField = new JTextField();
        JComboBox<String> nivelCombo = new JComboBox<>(controller.getNiveisSubstituto());
        JComboBox<String> titulacaoCombo = new JComboBox<>(controller.getTitulacoes());
        JComboBox<Integer> cargaCombo = new JComboBox<>(controller.getCargasHorarias());
        
        panel.add(new JLabel("Código do Departamento:"));
        panel.add(codigoDeptField);
        panel.add(new JLabel("Código do Funcionário:"));
        panel.add(codigoField);
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Salário Base:"));
        panel.add(salarioField);
        panel.add(new JLabel("Nível:"));
        panel.add(nivelCombo);
        panel.add(new JLabel("Titulação:"));
        panel.add(titulacaoCombo);
        panel.add(new JLabel("Carga Horária:"));
        panel.add(cargaCombo);
        
        int result = JOptionPane.showConfirmDialog(this, panel, 
                    "Cadastrar Docente Substituto", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                String codigoDept = codigoDeptField.getText().trim();
                String codigo = codigoField.getText().trim();
                String nome = nomeField.getText().trim();
                double salario = Double.parseDouble(salarioField.getText().trim());
                String nivel = (String) nivelCombo.getSelectedItem();
                String titulacao = (String) titulacaoCombo.getSelectedItem();
                int cargaHoraria = (Integer) cargaCombo.getSelectedItem();
                
                if (controller.adicionarDocenteSubstituto(codigoDept, codigo, nome, salario, nivel, titulacao, cargaHoraria)) {
                    outputArea.append("Docente Substituto cadastrado com sucesso!\n");
                    outputArea.append("Nome: " + nome + ", Código: " + codigo + "\n\n");
                } else {
                    outputArea.append("Erro ao cadastrar docente substituto. Verifique se o departamento existe.\n\n");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Valor de salário inválido!");
            }
        }
    }
    
    // Métodos de relatórios
    private void gerarRelatorioGeral() {
        outputArea.append(controller.gerarRelatorioGeral());
        outputArea.append(controller.getUniversidade().geral());
    }
    
    private void gerarResumoDepartamentos() {
        outputArea.append(controller.gerarResumoDepartamentos());
    }
    
    private void departamentosPorFaixa() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        JTextField minField = new JTextField();
        JTextField maxField = new JTextField();
        
        panel.add(new JLabel("Valor Mínimo:"));
        panel.add(minField);
        panel.add(new JLabel("Valor Máximo:"));
        panel.add(maxField);
        
        int result = JOptionPane.showConfirmDialog(this, panel, 
                    "Faixa de Gastos", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                double min = Double.parseDouble(minField.getText().trim());
                double max = Double.parseDouble(maxField.getText().trim());
                
                outputArea.append(controller.gerarResumoDepartamentosPorFaixa(min, max));
                controller.getUniversidade().resumoDepEntre((int)min, (int)max);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Valores inválidos!");
            }
        }
    }
    
    private void funcionariosPorSalario() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        JTextField minField = new JTextField();
        JTextField maxField = new JTextField();
        
        panel.add(new JLabel("Salário Mínimo:"));
        panel.add(minField);
        panel.add(new JLabel("Salário Máximo:"));
        panel.add(maxField);
        
        int result = JOptionPane.showConfirmDialog(this, panel, 
                    "Faixa Salarial", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                double min = Double.parseDouble(minField.getText().trim());
                double max = Double.parseDouble(maxField.getText().trim());
                
                outputArea.append(controller.FuncionariosPorFaixaSalarial(min, max));
                controller.getUniversidade().funcionarioEntre((int)min, (int)max);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Valores inválidos!");
            }
        }
    }
    
    private void todosFuncionarios() {
        outputArea.append(controller.gerarRelatorioTodosFuncionarios());
        outputArea.append(controller.getUniversidade().exibirTodosFunc());
    }
    
    private void todosTecnicos() {
        outputArea.append(controller.gerarRelatorioTecnicos());
        controller.getUniversidade().exibirTecnicos();
    }
    
    private void todosDocentes() {
        outputArea.append(controller.gerarRelatorioDocentes());
        controller.getUniversidade().exibirDocentes();
    }
    
    private void docentesEfetivos() {
        outputArea.append(controller.gerarRelatorioDocentesEfetivos());
        controller.getUniversidade().exibirDocentesEfetivos();
    }
    
    private void docentesSubstitutos() {
        outputArea.append(controller.gerarRelatorioDocentesSubstitutos());
        controller.getUniversidade().exibirDocentesSubstitutos();
    }
    
    private void buscarPorCodigo() {
        String codigo = JOptionPane.showInputDialog(this, 
                       "Digite o código do funcionário:");
        
        if (codigo != null && !codigo.trim().isEmpty()) {
            outputArea.append(controller.buscarFuncionarioPorCodigo(codigo.trim()));
            controller.getUniversidade().exibirFuncByCod(codigo.trim());
        }
    }
    
    private void buscarPorNome() {
        String nome = JOptionPane.showInputDialog(this, 
                     "Digite o nome do funcionário:");
        
        if (nome != null && !nome.trim().isEmpty()) {
            outputArea.append(controller.buscarFuncionarioPorNome(nome.trim()));
            controller.getUniversidade().exibirFuncByNome(nome.trim());
        }
    }
    
    private void infoDepartamento() {
        String codigo = JOptionPane.showInputDialog(this, 
                       "Digite o código do departamento:");
        
        if (codigo != null && !codigo.trim().isEmpty()) {
            outputArea.append(controller.exibirInformacoesDepartamento(codigo.trim()));
            controller.getUniversidade().exibirInfoDepartamento(codigo.trim());
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getLookAndFeel());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            new SistemaUniversidadeGUI().setVisible(true);
        });
    }
}