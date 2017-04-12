$(document).ready(function() {
    setVisibleAttributes();

    $("#type").change(function() {
        setVisibleAttributes();
    });
    
    $("input").focus(function() {
        this.setCustomValidity("");
    });
    
    $("form").submit(function(event) {
        var selectedType = $("#type").val();
        
        if (selectedType === "article" || selectedType === "inproceedings") {
            pagesOk = checkPages(selectedType);
            console.log("häröhärö");
            if (!pagesOk) {
                $("#pages_start")[0].setCustomValidity("Tarkista sivunumerot.");
                $("#pages_end")[0].setCustomValidity("Tarkista sivunumerot.");
                event.preventDefault();
            } else {
                $("#pages_start")[0].setCustomValidity("");
                $("#pages_end")[0].setCustomValidity("");
            }
        }
    });
});

function setVisibleAttributes() {
    var selectedType = $("#type").val();
    
    switch(selectedType) {
        case "book":
            showHideHide(".book_attr", ".article_attr", ".inproc_attr");
            setRequiredAttrs(".book_req", ".article_req", ".inproc_req");
            break;
        case "inproceedings":
            showHideHide(".inproc_attr", ".article_attr", ".book_attr");
            setRequiredAttrs(".inproc_req", ".article_req", ".book_req");
            break;
        case "article":
            showHideHide(".article_attr", ".inproc_attr", ".book_attr");
            setRequiredAttrs(".article_req", ".inproc_req", ".book_req");
            break;
    }
};

function showHideHide(showThis, hideThis, hideThisAsWell) {
    $(hideThis).each(function() {
        $(this).hide();
    });
    $(hideThisAsWell).each(function() {
        $(this).hide();
    });
    $(showThis).each(function() {
        $(this).show();
    });
};

function setRequiredFields(fields, isRequired) {
    $.each(fields, function(key, val) {
        val.required = isRequired;
    });
};

function setRequiredAttrs(req, notReq, notReqEither) {
    setInputs(req, notReq, notReqEither);
    setLabels(req, notReq, notReqEither);
};

function setInputs(req, notReq, notReqEither) {
    $("input" + notReq).each(function() {
        $(this).prop('required', false);
    });
    $("input" + notReqEither).each(function() {
        $(this).prop('required', false);
    });
    $("input" + req).each(function() {
        $(this).prop('required', true);
    });
};

function setLabels(req, notReq, notReqEither) {
    $("label" + notReq).each(function() {
        $(this).css('font-weight', 'normal');
    });
    $("label" + notReqEither).each(function() {
        $(this).css('font-weight', 'normal');
    });
    $("label" + req).each(function() {
        $(this).css('font-weight', 'bold');
    });
};

function checkPages() {
    var pagesStart = $("#pages_start").val();
    var pagesEnd = $("#pages_end").val();
    var check = true;
    if (pagesStart.length > 0 && pagesEnd.length === 0) {
        check = false;
    }
    if (pagesStart.length === 0 && pagesEnd.length > 0) {
        check = false;
    }
    if (pagesStart.length > 0 && pagesEnd.length > 0) {
        if (pagesStart > pagesEnd) {
            check = false;
        }
    }
    
    return check;
};