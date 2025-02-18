const taskInput = document.getElementById("taskInput");
const addTaskButton = document.getElementById("addTaskBtn");
const taskList = document.getElementById("taskList");

addTaskButton.addEventListener("click", () => {
  const taskText = taskInput.value.trim();

  if (taskText !== "") {
    const taskItem = document.createElement("li");
    taskItem.className = "task-container";
    taskItem.innerHTML = `${taskText} <button class="delete-button">Eliminar</button>`;

    const deleteButton = taskItem.querySelector(".delete-button");
    deleteButton.addEventListener("click", () => {
      taskList.removeChild(taskItem);
    });

    taskList.appendChild(taskItem);

    taskInput.value = "";
  } else {
    alert("Escriu una tasca abans d\'afegir-la.");
  }
});