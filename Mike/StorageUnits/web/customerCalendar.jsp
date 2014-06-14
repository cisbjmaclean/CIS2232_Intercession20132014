<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>jQuery UI Datepicker - Icon trigger</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/styles/styles.css">
        <script>
            $(function() {
                $(".datepicker").datepicker({
                    showOn: "button",
                    buttonImage: "images/calendar.gif",
                    buttonImageOnly: true,
                    showButtonPanel: true,
                    minDate: 0, 
                    maxDate: "+36M"  
                    .datepicker("widget").css('font-size','10px');
                });
            });
        </script>
    </head>
    <body>
        <p>Date: <input type="text" class="datepicker"></p>
    </body>
</html>