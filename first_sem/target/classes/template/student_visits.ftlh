<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Мои посещения</title>
    <link rel="stylesheet" href="${currentContext}/static/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Мои посещения бассейна</h1>

    <div class="button-group">
        <a href="profile" class="btn">На главную</a>
        <a href="../student/addvisit" class="btn btn-primary">Добавить новое посещение</a>
    </div>

    <#if visits?? && visits?size gt 0>
        <table class="visits-table">
            <thead>
            <tr>
                <th>Дата посещения</th>
                <th>Время посещения</th>
                <th>Статус</th>
            </tr>
            </thead>
            <tbody>
            <#list visits as visit>
                <tr>
                    <td>${visit.visitDate!''}</td>
                    <td>${visit.visitTime!''}</td>
                    <td>
                        <#if visit.status == 'На рассмотрении'>
                            <span class="status-pending">${visit.status}</span>
                        <#elseif visit.status == 'Одобрено'>
                            <span class="status-approved">${visit.status}</span>
                        <#elseif visit.status == 'Отклонено'>
                            <span class="status-rejected">${visit.status}</span>
                        <#else>
                            ${visit.status!''}
                        </#if>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div class="no-visits">
            <p>У вас пока нет записей о посещениях.</p>
            <p>Нажмите "Добавить новое посещение", чтобы создать первую запись.</p>
        </div>
    </#if>
</div>
</body>
</html>