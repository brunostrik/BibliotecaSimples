<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Biblioteca</title>

    <!-- Adicione os links para os arquivos CSS do Bootstrap e a paleta de cores da Universidade Estadual de Londrina -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa; /* Cor de fundo da paleta da Universidade Estadual de Londrina */
            font-family: 'Franklin Gothic Medium', sans-serif; /* Fonte Franklin Gothic Medium */
        }

        .logo {
            text-align: center;
            padding: 20px;
        }

        .navbar {
            background-color: #007744; /* Cor da navbar da paleta da Universidade Estadual de Londrina */
        }
        .dropdown-menu{
            background-color: #70AA87;
        }

        .navbar-brand {
            color: #ffffff !important; /* Cor do texto da navbar da paleta da Universidade Estadual de Londrina */
            font-size: 24px;
            font-weight: bold;
        }

        .navbar-nav a {
            color: #ffffff !important; /* Cor do texto dos links da navbar da paleta da Universidade Estadual de Londrina */
            font-size: 18px;
            margin-right: 20px;
        }

        .navbar-nav a:hover {
            color: #005bb5 !important; /* Cor do texto ao passar o mouse sobre os links da paleta da Universidade Estadual de Londrina */
        }

        .content {
            padding: 20px;
            background: url('assets/rgl.jpg') no-repeat center center fixed;
            background-size: cover;
            height: 100vh; /* Ajuste a altura conforme necessário */
        }

    </style>
</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="#">
            <i class="fas fa-book-open"></i> Biblioteca
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <div class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="tituloDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Títulos e Exemplares
                        </a>
                        <div class="dropdown-menu" aria-labelledby="tituloDropdown">
                            <a class="dropdown-item" href="cadtitulo.jsp">Cadastrar Título</a>
                            <a class="dropdown-item" href="cadexemplar.jsp">Cadastrar Exemplar</a>
                            <a class="dropdown-item" href="listtitulo.jsp">Listar</a>
                        </div>
                    </div>
                </li>
                <div class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="alunoDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Alunos
                    </a>
                    <div class="dropdown-menu" aria-labelledby="alunoDropdown">
                        <a class="dropdown-item" href="cadaluno.jsp">Cadastrar</a>
                        <a class="dropdown-item" href="listaluno.jsp">Listar</a>
                    </div>
                </div>
                <li class="nav-item">
                    <a class="nav-link" href="emplivro.jsp">Emprestar Livro</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="devlivro.jsp">Devolver Livro</a>
                </li>
                
            </ul>
        </div>
    </div>
</nav>
