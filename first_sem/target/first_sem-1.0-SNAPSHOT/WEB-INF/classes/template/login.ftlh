<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Вход в систему</title>
    <link rel="stylesheet" href="${currentContext}/static/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Вход в систему</h1>

    <#if error??>
        <div class="error">${error}</div>
    </#if>

    <form method="post" action="login">
        <div class="form-group">
            <label>Email <span class="required">*</span></label>
            <input type="email" name="email" placeholder="Введите email" required>
        </div>

        <div class="form-group">
            <label>Пароль <span class="required">*</span></label>
            <input type="password" name="password" placeholder="Введите пароль" required>
        </div>

        <div class="form-group">
            <label>Роль <span class="required">*</span></label>
            <select name="role" required>
                <option value="">-- выберите роль --</option>
                <option value="student">Студент</option>
                <option value="teacher">Преподаватель</option>
            </select>
        </div>

        <div class="button-group">
            <button type="submit" class="btn">Войти</button>
        </div>
    </form>

    <div class="register-link">
        Нет аккаунта? <a href="register">Зарегистрироваться</a>
    </div>
</div>
</body>
</html>