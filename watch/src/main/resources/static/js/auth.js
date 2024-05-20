$(document).ready(function() {
    // Show login modal
    $('.login-modal').click(function(event) {
        event.preventDefault();
        $('#loginModal').modal('show');
    });

    // Show register modal and hide login modal
    $('.register-modal').click(function(event) {
        event.preventDefault();
        $('#loginModal').modal('hide');
        $('#registerModal').modal('show');
    });

    // Show login modal and hide register modal
    $('.login-from-signup-modal').click(function(event) {
        event.preventDefault();
        $('#registerModal').modal('hide');
        $('#loginModal').modal('show');
    });

    // Handle login form submission
    $('#loginModal form').submit(function(event) {
        event.preventDefault();

        const username = $('#usernameLogin').val();
        const password = $('#passwordLogin').val();
        const csrfToken = $('meta[name="csrf-token"]').attr('content');

        $.ajax({
            type: 'POST',
            url: '/login',  // Đường dẫn xử lý đăng nhập
            data: {
                username: username,
                password: password,
                _csrf: csrfToken  // Gửi kèm CSRF token nếu có
            },
            success: function(response) {
                if (response.redirectUrl) {
                    window.location.href = response.redirectUrl;
                } else {
                    console.log('Đăng nhập thành công');
                    $('#loginModal').modal('hide');
                    // Optionally redirect or update UI
                }
            },
            error: function(xhr, status, error) {
                console.error('Đăng nhập thất bại', xhr.responseText);
                // Optionally show error message
            }
        });
    });

    // Handle register form submission
    $('#registerModal form').submit(function(event) {
        event.preventDefault();

        const username = $('#usernameRegister').val();
        const password = $('#passwordRegister').val();
        const csrfToken = $('meta[name="csrf-token"]').attr('content');

        $.ajax({
            type: 'POST',
            url: '/register',  // Đường dẫn xử lý đăng ký
            contentType: 'application/json',
            data: JSON.stringify({
                username: username,
                password: password,
                _csrf: csrfToken  // Gửi kèm CSRF token nếu có
            }),
            success: function(response) {
                console.log('Đăng ký thành công');
                $('#registerModal').modal('hide');
                // Optionally redirect or update UI
            },
            error: function(xhr, status, error) {
                console.error('Đăng ký thất bại', xhr.responseText);
                // Optionally show error message
            }
        });
    });
});
