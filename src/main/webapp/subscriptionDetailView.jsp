<head>
    <script src="js/jquery-1.7.2.js"> </script>
    <script src="js/bootstrap.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/bootstrap-responsive.css"/>

    <script type="text/javascript">

        // -------------- Sub Notification Scheduler ------------------
        $(document).ready(function() {
            setTimeout(viewSubNotification, 3000);
        });


        function viewSubNotification() {
            $.ajax({
                url : 'subNotification',
                data : ({
                    name : $('#checkQuery').val()
                }),
                success : function(data) {
                    $('#subNotificationText').html(data);
                }

            });
            setTimeout(viewSubNotification, 3000);
        }

        // -------------- Get Subscription Base size ------------------
        $(document).ready(function () {
            $('#baseSizeButton').click(function (event) {
                event.preventDefault();
                checkQueryBaseSize()
            });
        });

        function checkQueryBaseSize() {
            $.ajax({
                url : 'checkBaseSize',
                data : ({
                    name : $('#checkQueryNew').val()
                }),
                success : function(data) {
                    $('#baseSize').html(data);
                }

            });
        }

        // ---------------- Get Subscription Status ----------------------------
        $(document).ready(function () {
            $('#subStatusButton').click(function (event) {
                event.preventDefault();
                checkSubStatus()
            });
        });

        function checkSubStatus() {
            $.ajax({
                url : 'checkStatus',
                data : ({
                    name : $('#subStatusData').val()
                }),
                success : function(data) {
                    $('#subStatus').html(data);
                }

            });
        }

        // ---------------- Subscription Register ----------------------------
        $(document).ready(function () {
            $('#subRegisterButton').click(function (event) {
                event.preventDefault();
                sendSubRegistration()
            });
        });

        function sendSubRegistration() {
            $.ajax({
                url : 'subRegister',
                data : ({
                    name : $('#mobileNumber').val()
                }),
                success : function(data) {
                    $('#subRegisterStatus').html(data);
                }

            });
        }

    </script>

    <style>
        #formHeight{
            height: 25px;
        }
    </style>

</head>

<body>


<div class="container">
    <br>
    <br>
    <div class="row">
        <h1><span style="color: #275387; margin-left:450px">Subscription App</span></h1>
    </div>

    <br>
    <div class="row">

        <%------------------ View Subscription Base Size ------------------------------%>
        <div class="well span3" style="margin-left: 100px">
            <h4><span style="color: #275387">Subscription BaseSize</span></h4>
            <button id="baseSizeButton" type="submit" class="btn btn-info">Get BaseSize</button>
            <form class="form-inline">
                <br>
                <label>Base Size : </label>
                <label id="baseSize" class="text-error">0</label>
            </form>
        </div>

        <%------------------ View Subscription Registration Status ------------------------------%>
        <div class="well span3">
            <h4><span style="color: #275387">App Registration</span></h4>
            <button id="subRegisterButton" type="submit" class="btn btn-info">Register Now</button>
            <form class="form-inline">
                <br>
                <label>Status : </label>
                <label id="subRegisterStatus" class="text-error">Pending</label>
            </form>
        </div>

        <%------------------ View Subscription Status ------------------------------%>
        <div class="well span3">
            <h4><span style="color: #275387">Subscription Status</span></h4>
            <button id="subStatusButton" type="submit" class="btn btn-info">Get Status</button>
            <br>
            <form class="form-inline">
                <br>
                <label>Status : </label>
                <label id="subStatus" class="text-error">Pending</label>
            </form>
        </div>
    </div>

    <br>
    <br>
    <div class="row">
        <%------------------ Display Received Subscription Notification ------------------------------%>
        <div class="well span10" style="margin-left: 100px">
            <h3><span style="color: #275387">Subscription Notification</span></h3>
            <br>
            <textarea id="subNotificationText" class="field span10" rows="7"></textarea>
        </div>
    </div>

</div>


