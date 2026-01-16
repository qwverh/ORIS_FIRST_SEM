<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Мои студенты</title>
    <link rel="stylesheet" href="${currentContext}/static/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Мои студенты</h1>

    <div class="button-group">
        <a href="profile" class="btn">На главную</a>
    </div>

    <#if students?? && students?size gt 0>
        <table class="students-table">
            <thead>
            <tr>
                <th>ФИО студента</th>
                <th>Email</th>
                <th>Группа</th>
                <th>Курс</th>
            </tr>
            </thead>
            <tbody>
            <#list students as student>
                <tr>
                    <td>
                        <span class="student-name">${student.fullName}</span>
                    </td>
                    <td>
                        <span class="student-email">${student.email}</span>
                    </td>
                    <td>
                        <span class="group-badge">${student.groupNumber}</span>
                    </td>
                    <td>
                        <span class="course-badge">${student.courseNumber} курс</span>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div class="no-students">
            <p>У вас пока нет прикрепленных студентов.</p>
            <p>Студенты могут выбрать вас в своем профиле.</p>
        </div>
    </#if>
</div>
</body>
</html>