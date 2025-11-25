document.addEventListener('DOMContentLoaded', function() {
    const visitDateInput = document.getElementById('visit_date');
    if (visitDateInput) {
        const today = new Date().toISOString().split('T')[0];
        visitDateInput.max = today;
        visitDateInput.value = today;
    }
});