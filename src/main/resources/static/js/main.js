$('document').ready(function() {
    $('.table #editBookBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(books, status){
                    $('#idEdit').val(books.id);
                    $('#titleEdit').val(books.title);
                    $('#authorEdit').val(books.author);
                    $('#isbnEdit').val(books.isbn);
                    $('#release_dayEdit').val(books.release_day);
                });
        $('#editBookModal').modal();
    });
    $('.table #deleteButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
    $('.table #editStudentBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(students, status){
             $('#idEdit').val(students.id);
             $('#firstNameEdit').val(students.firstName);
             $('#lastNameEdit').val(students.lastName);
             $('#phoneEdit').val(students.phone);
             $('#birthdayEdit').val(students.birthday);
        });
        $('#editStudentModal').modal();
    });
    $('.table #editLoanBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $.get(href, function(loans, status){
                        $('#editLoanId').val(loans.id);
                        $('#editBook').val(loans.book?.id);
                        $('#editStudent').val(loans.student?.id);
                        $('#editLoanStart').val(loans.loan_start);
                        $('#editLoanEnd').val(loans.loanEnd);
                    });
            $('#editLoanModal').modal();
        });
});