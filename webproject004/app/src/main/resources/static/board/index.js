  var tbody = document.querySelector("#x-board-table tbody")

  fetch("/board/list")
    .then(function(response) {
      return response.json();
    })
    .then(function(boards) {
      console.log(boards);
      for (var board of boards) {
        var tr = document.createElement("tr");
        tr.innerHTML = `<td>${board.no}</td>
        <td><a href="view.html?no=${board.no}">${board.title}</a></td>
        <td>${board.viewCount}</td>
        <td>${board.createdDate}</td>`;
        tbody.appendChild(tr);
      }
    });