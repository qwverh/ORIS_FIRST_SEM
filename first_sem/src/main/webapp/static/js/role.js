document.addEventListener('DOMContentLoaded', function() {
    const roleSelect = document.getElementById('roleSelect');
    const studentFields = document.getElementById('studentFields');

    if (roleSelect && studentFields) {
        roleSelect.addEventListener('change', () => {
            if (roleSelect.value === 'student') {
                studentFields.style.display = 'block';
                document.querySelector('input[name="group_number"]').required = true;
                document.querySelector('input[name="course_number"]').required = true;
            } else {
                studentFields.style.display = 'none';
                document.querySelector('input[name="group_number"]').required = false;
                document.querySelector('input[name="course_number"]').required = false;
            }
        });

        if (roleSelect.value === 'student') {
            studentFields.style.display = 'block';
            document.querySelector('input[name="group_number"]').required = true;
            document.querySelector('input[name="course_number"]').required = true;
        }
    }
});