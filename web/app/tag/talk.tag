<talk>
    <section>
        <form>
            <input id="person-id" class="form-control" type="text" placeholder="To Who ...">
            <textarea id="message" class="form-control"></textarea>
            <button id="send" class="form-control" onclick="{sendMessage}">Send</button>
        </form>
    </section>

    <script>
        this.sendMessage = function () {
            var ws = new WebSocket("ws://localhost:8080/ws/");

            ws.onopen = function(e) {
                console.log('ssaddadasdsa');
            }
        }
    </script>
</talk>
