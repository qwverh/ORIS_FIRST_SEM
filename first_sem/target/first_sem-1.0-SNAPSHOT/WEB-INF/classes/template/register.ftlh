<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация в системе</title>
    <link rel="stylesheet" href="${currentContext}/static/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Регистрация</h1>

    <form method="post" action="register">
        <div class="form-group">
            <label>ФИО <span class="required">*</span></label>
            <input type="text" name="full_name" placeholder="Введите ваше полное имя" required>
        </div>

        <div class="form-group">
            <label>Email <span class="required">*</span></label>
            <input type="email" name="email" placeholder="example@mail.ru" required>
        </div>

        <div class="form-group">
            <label>Пароль <span class="required">*</span></label>
            <input type="password" name="password" placeholder="Не менее 6 символов" required>
        </div>

        <div class="form-group">
            <label>Роль <span class="required">*</span></label>
            <select id="roleSelect" name="role" required>
                <option value="">-- выберите роль --</option>
                <option value="student">Студент</option>
                <option value="teacher">Преподаватель</option>
            </select>
        </div>

        <div id="studentFields" class="additional-fields" style="display:none;">
            <h4>Информация о студенте</h4>
            <div class="form-group">
                <label>Номер группы <span class="required">*</span></label>
                <input type="text" name="group_number" placeholder="Например: 11-403">
            </div>
            <div class="form-group">
                <label>Курс <span class="required">*</span></label>
                <input type="number" name="course_number" min="1" max="6" placeholder="От 1 до 6">
            </div>
        </div>

        <div class="button-group">
            <button type="submit" class="btn">Зарегистрироваться</button>
        </div>
    </form>

    <div class="login-link">
        Уже есть аккаунт? <a href="login">Войти</a>
    </div>
</div>
<script src="${currentContext}/static/js/role.js"></script>
</body>
</html>