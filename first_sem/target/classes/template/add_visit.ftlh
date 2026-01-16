<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Добавить посещение</title>
    <link rel="stylesheet" href="${currentContext}/static/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Добавить новое посещение</h1>

    <form method="post" action="addvisit">
        <div class="form-group">
            <label for="visit_date">Дата посещения <span class="required">*</span></label>
            <input type="date" id="visit_date" name="visit_date" required>
            <div class="info-text">Можно выбрать любую дату до сегодняшней включительно</div>
        </div>

        <div class="form-group">
            <label for="visit_time">Время посещения <span class="required">*</span></label>
            <input type="time" id="visit_time" name="visit_time" required>
        </div>

        <div class="button-group">
            <button type="submit" class="btn btn-create">Создать посещение</button>
            <a href="visits" class="btn btn-cancel">Отмена</a>
        </div>
    </form>
</div>

<script src="${currentContext}/static/js/date.js"></script>
</body>
</html>