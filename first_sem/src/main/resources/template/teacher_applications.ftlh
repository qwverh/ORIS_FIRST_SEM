<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Заявки на посещения</title>
    <link rel="stylesheet" href="${currentContext}/static/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Заявки на посещения бассейна</h1>

    <div class="button-group">
        <a href="profile" class="btn">На главную</a>
    </div>

    <#if applications?? && applications?size gt 0>
        <table class="applications-table">
            <thead>
            <tr>
                <th>Студент</th>
                <th>Группа</th>
                <th>Курс</th>
                <th>Дата посещения</th>
                <th>Время посещения</th>
                <th>Статус</th>
                <th>Действия</th>
            </tr>
            </thead>
            <tbody>
            <#list applications as app>
                <tr>
                    <td>
                        <span class="student-name">${app.studentName}</span>
                    </td>
                    <td>
                        <span class="group-badge">${app.groupNumber}</span>
                    </td>
                    <td>
                        <span class="course-badge">${app.course} курс</span>
                    </td>
                    <td>${app.visitDate?string('dd.MM.yyyy')}</td>
                    <td>${app.visitTime?string('HH:mm')}</td>
                    <td>
                        <span class="status-pending">${app.status}</span>
                    </td>
                    <td>
                        <form method="post" style="display: inline;">
                            <input type="hidden" name="student_id" value="${app.studentId}">
                            <input type="hidden" name="visit_id" value="${app.visitId}">
                            <div class="action-buttons">
                                <button type="submit" name="action" value="approve" class="btn-approve"
                                        onclick="return confirm('Одобрить посещение?')">
                                    Одобрить
                                </button>
                                <button type="submit" name="action" value="reject" class="btn-reject"
                                        onclick="return confirm('Отклонить посещение?')">
                                    Отклонить
                                </button>
                            </div>
                        </form>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div class="no-applications">
            <p>Нет заявок на рассмотрении.</p>
            <p>Все заявки ваших студентов будут отображаться здесь.</p>
        </div>
    </#if>
</div>
</body>
</html>