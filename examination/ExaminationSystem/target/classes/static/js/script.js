document.addEventListener('DOMContentLoaded', () => {

  // Helper: Show error message below input
  function showError(inputElem, message) {
    let errorElem = inputElem.nextElementSibling;
    if (errorElem && errorElem.classList.contains('error-message')) {
      errorElem.textContent = message;
    }
  }

  // Helper: Clear error messages inside a form
  function clearErrors(form) {
    form.querySelectorAll('.error-message').forEach(el => el.textContent = '');
  }

  // --- Register Form Validation ---
  const registerForm = document.querySelector('form[action="/register"]');
  if (registerForm) {
    registerForm.addEventListener('submit', e => {
      clearErrors(registerForm);

      const username = registerForm.querySelector('input[name="username"]');
      const email = registerForm.querySelector('input[name="email"]');
      const password = registerForm.querySelector('input[name="password"]');
      const role = registerForm.querySelector('select[name="role"]');

      let valid = true;

      if (!username.value.trim()) {
        showError(username, 'Username is required');
        valid = false;
      }

      if (!email.value.trim()) {
        showError(email, 'Email is required');
        valid = false;
      } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email.value)) {
        showError(email, 'Invalid email format');
        valid = false;
      }

      if (!password.value.trim()) {
        showError(password, 'Password is required');
        valid = false;
      } else if (password.value.length < 6) {
        showError(password, 'Password must be at least 6 characters');
        valid = false;
      }

      if (!role.value) {
        showError(role, 'Role must be selected');
        valid = false;
      }

      if (!valid) e.preventDefault();
    });
  }

  // --- Login Form Validation ---
  const loginForm = document.querySelector('form[action="/login"]');
  if (loginForm) {
    loginForm.addEventListener('submit', e => {
      clearErrors(loginForm);

      const userOrEmail = loginForm.querySelector('input[name="usernameOrEmail"]');
      const password = loginForm.querySelector('input[name="password"]');

      let valid = true;

      if (!userOrEmail.value.trim()) {
        showError(userOrEmail, 'Username or Email is required');
        valid = false;
      }

      if (!password.value.trim()) {
        showError(password, 'Password is required');
        valid = false;
      }

      if (!valid) e.preventDefault();
    });
  }

  // --- Create / Update Exam Form Validation ---
  const examForm = document.querySelector('form[action*="/exam/"]');
  if (examForm) {
    examForm.addEventListener('submit', e => {
      clearErrors(examForm);

      const name = examForm.querySelector('input[id="name"]');
      const subject = examForm.querySelector('input[id="subject"]');
      const date = examForm.querySelector('input[id="scheduledDate"]');
      const time = examForm.querySelector('input[id="scheduledTime"]');

      let valid = true;

      if (!name.value.trim()) {
        showError(name, 'Exam name is required');
        valid = false;
      }

      if (!subject.value.trim()) {
        showError(subject, 'Subject is required');
        valid = false;
      }

      if (!date.value) {
        showError(date, 'Scheduled date is required');
        valid = false;
      }

      if (!time.value) {
        showError(time, 'Scheduled time is required');
        valid = false;
      }

      if (!valid) e.preventDefault();
    });
  }

  // --- Confirm before delete links ---
  document.querySelectorAll('a.btn.btn-secondary').forEach(link => {
    const href = link.getAttribute('href');
    if (href && href.includes('/exam/delete/')) {
      link.addEventListener('click', (e) => {
        const confirmed = confirm('Are you sure you want to delete this exam?');
        if (!confirmed) e.preventDefault();
      });
    }
  });

});
