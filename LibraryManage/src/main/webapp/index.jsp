<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Segoe UI', Arial, sans-serif;
    }

    body {
        background: #f4f6f9;
        color: #333;
    }

    /* ===== NAVBAR ===== */
    header {
        background: #1e3c72;
        padding: 15px 40px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        color: #fff;
    }

    header h2 {
        font-size: 22px;
        letter-spacing: 1px;
    }

    nav a {
        color: #fff;
        text-decoration: none;
        margin-left: 20px;
        font-weight: 500;
    }

    nav a:hover {
        text-decoration: underline;
    }

/* ===== HERO SECTION (Glassmorphism) ===== */
.hero {
    position: relative;
    min-height: 85vh;
    background: 
        linear-gradient(rgba(30,60,114,0.6), rgba(42,82,152,0.6)),
        url("images/library-bg.jpg") center/cover no-repeat;
    display: flex;
    align-items: center;
    justify-content: center;
}

.hero-glass {
    background: rgba(255, 255, 255, 0.15);
    backdrop-filter: blur(12px);
    -webkit-backdrop-filter: blur(12px);
    border-radius: 16px;
    padding: 50px 60px;
    text-align: center;
    color: #fff;
    box-shadow: 0 15px 35px rgba(0,0,0,0.25);
    border: 1px solid rgba(255,255,255,0.3);
    max-width: 700px;
}

.hero-glass h1 {
    font-size: 40px;
    margin-bottom: 15px;
}

.hero-glass p {
    font-size: 17px;
    opacity: 0.95;
}

    /* ===== FEATURES ===== */
    .features {
        padding: 60px 40px;
        max-width: 1100px;
        margin: auto;
    }

    .features h2 {
        text-align: center;
        margin-bottom: 40px;
        color: #2a5298;
    }

    .card-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
        gap: 25px;
    }

    .card {
        background: #fff;
        padding: 25px;
        border-radius: 12px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.1);
        text-align: center;
        transition: 0.3s;
    }

    .card:hover {
        transform: translateY(-6px);
        box-shadow: 0 15px 30px rgba(0,0,0,0.15);
    }

    .card h3 {
        color: #2a5298;
        margin-bottom: 10px;
    }

    .card p {
        font-size: 14px;
        margin-bottom: 15px;
        color: #555;
    }

    .card a {
        display: inline-block;
        padding: 10px 18px;
        background: #2a5298;
        color: #fff;
        border-radius: 6px;
        text-decoration: none;
        font-size: 14px;
    }

    .card a:hover {
        background: #1e3c72;
    }

    /* ===== FOOTER ===== */
    footer {
        background: #1e3c72;
        color: #fff;
        text-align: center;
        padding: 15px;
        margin-top: 40px;
        font-size: 14px;
    }
</style>
</head>

<body>

<header>
    <h2>📚 Library System</h2>
    <nav>
        <a href="index.jsp">Home</a>
        <a href="view-member.jsp">Members</a>
        <a href="view-books.jsp">Books</a>
        <a href="issue-book.jsp">Issue</a>
        <a href="return-book.jsp">Return</a>
    </nav>
</header>

<section class="hero">
    <div class="hero-glass">
        <h1>Library Management System</h1>
        <p>
            A modern platform to manage books, members, issuing and returns
            with speed and accuracy.
        </p>
    </div>
</section>

<section class="features">
    <h2>Library Operations</h2>

    <div class="card-grid">
        <div class="card">
            <h3>Add Member</h3>
            <p>Register new library members easily</p>
            <a href="add-member.jsp">Add Member</a>
        </div>

        <div class="card">
            <h3>View Members</h3>
            <p>View and manage all registered members</p>
            <a href="view-member.jsp">View Members</a>
        </div>

        <div class="card">
            <h3>Add Book</h3>
            <p>Add new books with details and quantity</p>
            <a href="add-book.jsp">Add Book</a>
        </div>

        <div class="card">
            <h3>View Books</h3>
            <p>Check available books in library</p>
            <a href="view-books.jsp">View Books</a>
        </div>

        <div class="card">
            <h3>Issue Book</h3>
            <p>Issue books to registered members</p>
            <a href="issue-book.jsp">Issue Book</a>
        </div>

        <div class="card">
            <h3>Return Book</h3>
            <p>Return issued books safely</p>
            <a href="return-book.jsp">Return Book</a>
        </div>
    </div>
</section>

<footer>
    © 2025 Library Management System | JSP & Servlet Project
</footer>

</body>
</html>
