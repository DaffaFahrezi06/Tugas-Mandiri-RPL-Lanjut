<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body { font-family: Arial, sans-serif; margin: 40px; }
    .form-group { margin-bottom: 15px; }
    label { display: inline-block; min-width: 30px; font-weight: bold; }
    input[type="number"] { padding: 6px; width: 120px; }
    button { padding: 8px 16px; background-color: #007bff; color: white; border: none; cursor: pointer; border-radius: 4px; }
    button:hover { background-color: #0056b3; }
    .result-box { margin-top: 20px; padding: 15px; background-color: #f8f9fa; border-left: 4px solid #007bff; }
</style>
</head>
<body>
    <h2>Menghitung Gaji dan Tabungan Mingguan</h2>

    <form action="/calculate" method="post">
        <div class="form-group">
            <label for="jam">Durasi Bekerja Minggu Ini:</label>
            <input type="number" step="any" id="jam" name="jam" required />
        </div>
        <div class="form-group">
            <label for="biaya">Pengeluaran Minggu Ini:</label>
            <input type="number" step="any" id="biaya" name="biaya" required />
        </div>
        <button type="submit">Hitung Gaji dan Tabungan</button>
    </form>
    
    <% if (request.getAttribute("result") != null) { %>
        <div class="result-box">
            <h3>Hasil Perhitungan:</h3>
            <p>${result}</p>
        </div>
    <% } %>
</body>
</html>