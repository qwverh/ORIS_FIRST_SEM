<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Редактирование профиля</title>
    <link rel="stylesheet" href="${currentContext}/static/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Редактирование профиля</h1>

    <#if error??>
        <div style="color: red; margin-bottom: 15px;">${error}</div>
    </#if>

    <form method="post">
        <div class="section">
            <div class="form-group">
                <label>ФИО:</label>
                <input type="text" name="full_name" value="${student.fullName}" required>
            </div>

            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" value="${student.email}" required>
            </div>

            <div class="form-group">
                <label>Группа:</label>
                <input type="text" name="group_number" value="${student.groupNumber}" required>
            </div>

            <div class="form-group">
                <label>Курс:</label>
                <input type="number" name="course_number" value="${student.courseNumber}" min="1" max="6" required>
            </div>
        </div>

        <div class="section">
            <h3>Преподаватель</h3>
            <div class="form-group">
                <label>Выберите преподавателя:</label>
                <select name="teacher_id">
                    <option value="">-- Без преподавателя --</option>
                    <#list teachers as teacher>
                        <option value="${teacher.id}"
                                <#if student.teacherId?? && student.teacherId == teacher.id>selected</#if>>
                            ${teacher.fullName} (${teacher.email})
                        </option>
                    </#list>
                </select>
            </div>
        </div>

        <div class="button-group">
            <button type="submit" name="action" value="update" class="btn btn-save">Сохранить изменения</button>
            <a href="profile" class="btn btn-cancel">Отмена</a>
        </div>

        <div style="margin-top: 30px; padding-top: 20px; border-top: 1px solid #eee;">
            <button type="submit" name="action" value="delete" class="btn btn-delete"
                    onclick="return confirm('Вы уверены, что хотите удалить профиль? Это действие нельзя отменить.')">
                Удалить профиль
            </button>
        </div>
    </form>
</div>
</body>
</html>