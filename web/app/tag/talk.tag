<talk>
    <section>
        <form>
            <input id="personId" class="form-control" type="text" placeholder="To Who ...">
            <textarea id="message" class="form-control"></textarea>
            <button id="send" class="form-control" onclick="{sendMessage}">Send</button>
        </form>
    </section>

    <script>
        var ws = new WebSocket("ws://localhost:8080/ws/");

        ws.onopen = function (e) {
            console.log('socket is open.', e);
        };

        ws.onclose = function (e) {
            console.log('socket is closed.', e);
        };

        ws.onmessage = function (m) {
            console.log("Receive message:", m);
        };

        var self = this;
        this.sendMessage = function () {
            ws.send(JSON.stringify(
                    {
                        personId: self.personId.value,
                        message: self.message.value
                    }
            ))
        }
    </script>
</talk>
