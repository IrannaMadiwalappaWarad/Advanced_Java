<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Result Form</title>

<script>
function validateForm() {
    let marks = document.querySelectorAll(".marks");

    for (let m of marks) {
        if (m.value === "" || m.value < 0 || m.value > 100) {
            alert("Enter valid marks (0-100)");
            return false;
        }
    }
    return true;
}
</script>

<style>
.container {
    width: 320px;
    margin: 50px auto;
    padding: 20px;
    border: 1px solid #ccc;
}
.field {
    margin: 10px 0;
}
</style>

</head>
<body>

<div class="container">
<h2>Student Result Form</h2>

<form action="processResult" method="POST" onsubmit="return validateForm()">

<div class="field">
Roll No: <input type="text" name="rollno" required>
</div>

<div class="field">
Name: <input type="text" name="name" required>
</div>

<div class="field">Sub1: <input type="number" name="sub1" class="marks" required></div>
<div class="field">Sub2: <input type="number" name="sub2" class="marks" required></div>
<div class="field">Sub3: <input type="number" name="sub3" class="marks" required></div>
<div class="field">Sub4: <input type="number" name="sub4" class="marks" required></div>
<div class="field">Sub5: <input type="number" name="sub5" class="marks" required></div>

<div class="field">
<input type="submit" value="Calculate Result">
</div>

</form>
</div>

</body>
</html>
