<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Kalkulator Rumus Kuadrat</title>
<style>
    body { font-family: Arial, sans-serif; margin: 40px; }
    .form-group { margin-bottom: 15px; }
    label { display: inline-block; width: 30px; font-weight: bold; }
    input[type="number"] { padding: 6px; width: 120px; }
    button { padding: 8px 16px; background-color: #007bff; color: white; border: none; cursor: pointer; border-radius: 4px; }
    button:hover { background-color: #0056b3; }
    .result-box { margin-top: 20px; padding: 15px; background-color: #f8f9fa; border-left: 4px solid #007bff; }
</style>
</head>
<body>
    <h2>Kalkulator Persamaan Kuadrat (ax² + bx + c = 0)</h2>

    <form action="/calculate" method="post">
        <div class="form-group">
            <label for="a">a:</label>
            <input type="number" step="any" id="a" name="a" value="${a}" required />
        </div>
        <div class="form-group">
            <label for="b">b:</label>
            <input type="number" step="any" id="b" name="b" value="${b}" required />
        </div>
        <div class="form-group">
            <label for="c">c:</label>
            <input type="number" step="any" id="c" name="c" value="${c}" required />
        </div>
        <button type="submit">Hitung Akar</button>
    </form>

    <% if (request.getAttribute("result") != null) { %>
        <div class="result-box">
            <h3>Hasil Perhitungan:</h3>
            <p>${result}</p>
        </div>
    <% } %>
</body>
</html>