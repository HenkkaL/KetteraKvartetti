var CHECKED_N = 0;

$(document).ready(function() {
    enableDownloadSubmitButton();
    
    $("#select_all").change(function() {
        checkAll(".checkbox", $("#select_all").prop('checked'));
    });
    
    $(".checkbox").change(function() {
        CHECKED_N += $(this).prop('checked') ? 1 : -1;
        enableDownloadSubmitButton();
    });
});

function checkAll(elements, checked) {
    $(elements).each(function() {
        if ($(this).prop('checked') !== checked) {
            $(this).prop('checked', checked);
            CHECKED_N += checked ? 1 : -1;
        }
    });
    enableDownloadSubmitButton();
};

function enableDownloadSubmitButton() {
    if (CHECKED_N <= 0) {
        CHECKED_N = 0;
        $("#download").prop('disabled', true);
    } else {
        $("#download").prop('disabled', false);
    }
};
