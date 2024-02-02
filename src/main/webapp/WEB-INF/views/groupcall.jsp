<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">


    <link rel="stylesheet" href="style.css">

    <script src="./webjars/webrtc-adapter/release/adapter.js"></script>

    <script src="conferenceroom.js"></script>
    <script src="participant.js"></script>


    <script src="./js/kurento-utils.js"></script>

</head>
<body>
<div id="container">
    <div id="wrapper">
        <div id="join" class="animate join">
            <h1>Join a Room</h1>
            <form onsubmit="register(); return false;" accept-charset="UTF-8">
                <p>
                    <input type="text" name="name" value="" id="name"
                           placeholder="Username" required>
                </p>
                <p>
                    <input type="text" name="room" value="" id="roomName"
                           placeholder="Room" required>
                </p>
                <p class="submit">
                    <input type="submit" name="commit" value="Join!">
                </p>
            </form>
        </div>
        <div id="room" style="display: none;">
            <h2 id="room-header"></h2>
            <div id="participants"></div>
            <input type="button" id="button-leave" onmouseup="leaveRoom();"
                   value="Leave room">
        </div>
    </div>
</div>
</body>
</html>
