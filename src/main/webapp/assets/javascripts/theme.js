(function() {
    $(document).ready(function() {
        setScrollable();
        setTimeAgo();
        setAutoSize();
        setCharCounter();
        setMaxLength();
        setValidateForm();
        setSortable($(".sortable"));
        setSelect2();
        try{
        	$(".datetimepicker").datetimepicker();
        	$(".datepicker").datetimepicker({
        		pickTime: false
        	});
        	$(".timepicker").datetimepicker({
        		pickDate: false
        	});
        }catch(e){}
        try{$('.wysihtml5').wysihtml5();}catch(e){}
        try{$('.dd').nestable();}catch(e){}
        try{
        	$("input.nakedpassword").nakedPassword({
        		path: "assets/images/plugins/naked_password/"
        	});
        }catch(e){}
        try{$('.nav-responsive.nav-pills, .nav-responsive.nav-tabs').tabdrop();}catch(e){}
        try{
        	setDataTable($(".data-table"));
        	setDataTable($(".data-table-column-filter")).columnFilter();
        }catch(e){}
        $(".box .box-remove").click(function(e) {
            $(this).parents(".box").first().remove();
            return e.preventDefault();
        });
        $(".box .box-collapse").click(function(e) {
            var box;

            box = $(this).parents(".box").first();
            box.toggleClass("box-collapsed");
            return e.preventDefault();
        });
        $("body").on("mouseenter", ".has-popover", function() {
            var el;

            el = $(this);
            if (el.data("popover") === undefined) {
                el.popover({
                    placement: el.data("placement") || "top",
                    container: "body"
                });
            }
            return el.popover("show");
        });
        $("body").on("mouseleave", ".has-popover", function() {
            return $(this).popover("hide");
        });
        $("body").on("mouseenter", ".has-tooltip", function() {
            var el;

            el = $(this);
            if (el.data("tooltip") === undefined) {
                el.tooltip({
                    placement: el.data("placement") || "top",
                    container: "body"
                });
            }
            return el.tooltip("show");
        });
        $("body").on("mouseleave", ".has-tooltip", function() {
            return $(this).tooltip("hide");
        });
        $("#check-all").click(function() {
            return $(this).parents("table:eq(0)").find(".only-checkbox :checkbox").attr("checked", this.checked);
        });
        try{
	        $(".colorpicker-hex").colorpicker({
	            format: "hex"
	        });
	        $(".colorpicker-rgb").colorpicker({
	            format: "rgb"
	        });
        }catch(e){}
        if (!Modernizr.input.placeholder) {
            $("[placeholder]").focus(function() {
                var input;

                input = $(this);
                if (input.val() === input.attr("placeholder")) {
                    input.val("");
                    return input.removeClass("placeholder");
                }
            }).blur(function() {
                    var input;

                    input = $(this);
                    if (input.val() === "" || input.val() === input.attr("placeholder")) {
                        input.addClass("placeholder");
                        return input.val(input.attr("placeholder"));
                    }
                }).blur();
            $("[placeholder]").parents("form").submit(function() {
                return $(this).find("[placeholder]").each(function() {
                    var input;

                    input = $(this);
                    if (input.val() === input.attr("placeholder")) {
                        return input.val("");
                    }
                });
            });
        }
        try{
	        if (!$("body").hasClass("fixed-header")) {
	            return $('#main-nav.main-nav-fixed').affix({
	                offset: 40
	            });
	        }
        }catch(e){}
    });

    this.setSelect2 = function(selector) {
        if (selector == null) {
            selector = $(".select2");
        }
        return selector.each(function(i, elem) {
            return $(elem).select2();
        });
    };

    this.setValidateForm = function(selector) {
        if (selector == null) {
            selector = $(".validate-form");
        }
        return selector.each(function(i, elem) {
            return $(elem).validate({
                errorElement: "span",
                errorClass: "help-block error",
                errorPlacement: function(e, t) {
                    return t.parents(".controls").append(e);
                },
                highlight: function(e) {
                    return $(e).closest(".control-group").removeClass("error success").addClass("error");
                },
                success: function(e) {
                    return e.closest(".control-group").removeClass("error");
                }
            });
        });
    };

    this.setDataTable = function(selector) {
    	if(selector.dataTable === undefined)
        	return false;
        return selector.dataTable({
            sDom: "<'row-fluid'<'span6'l><'span6 text-right'f>r>t<'row-fluid'<'span6'i><'span6 text-right'p>>",
            sPaginationType: "bootstrap",
            oLanguage: {
                sLengthMenu: "_MENU_ 每页最大记录数"
            }
        });
    };

    this.setMaxLength = function(selector) {
        if (selector == null) {
            selector = $(".char-max-length");
        }
        if(selector.maxlength === undefined)
        	return false;
        return selector.maxlength();
    };

    this.setCharCounter = function(selector) {
        if (selector == null) {
            selector = $(".char-counter");
        }
        if(selector.charCount === undefined)
        	return false;
        return selector.charCount({
            allowed: selector.data("char-allowed"),
            warning: selector.data("char-warning"),
            cssWarning: "text-warning",
            cssExceeded: "text-error"
        });
    };

    this.setAutoSize = function(selector) {
        if (selector == null) {
            selector = $(".autosize");
        }
        if(selector.autosize === undefined)
        	return false;
        return selector.autosize();
    };

    this.setTimeAgo = function(selector) {
        if (selector == null) {
            selector = $(".timeago");
        }
        if(selector.timeago === undefined)
        	return false;
        jQuery.timeago.settings.allowFuture = true;
        jQuery.timeago.settings.refreshMillis = 60000;
        selector.timeago();
        return selector.addClass("in");
    };

    this.setScrollable = function(selector) {
        if (selector == null) {
            selector = $(".scrollable");
        }
        return selector.each(function(i, elem) {
            return $(elem).slimScroll({
                height: $(elem).data("scrollable-height"),
                start: $(elem).data("scrollable-start") || "top"
            });
        });
    };

    this.setSortable = function(selector) {
        if (selector == null) {
            selector = null;
        }
        if (selector && selector.sortable !== undefined) {
            return selector.sortable({
                axis: selector.data("sortable-axis"),
                connectWith: selector.data("sortable-connect")
            });
        }
    };

}).call(this);