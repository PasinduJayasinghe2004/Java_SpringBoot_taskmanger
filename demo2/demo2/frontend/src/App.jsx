import { useState, useEffect } from 'react'

function App() {
  const [tasks, setTasks] = useState([])
  const [newTask, setNewTask] = useState('')
  const [loading, setLoading] = useState(true)

  const API_URL = 'http://localhost:8080/tasks'

  useEffect(() => {
    fetchTasks()
  }, [])

  const fetchTasks = async () => {
    try {
      const response = await fetch(API_URL)
      const data = await response.json()
      setTasks(data)
    } catch (error) {
      console.error('Error fetching tasks:', error)
    } finally {
      setLoading(false)
    }
  }

  const addTask = async (e) => {
    e.preventDefault()
    if (!newTask.trim()) return

    try {
      const response = await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title: newTask })
      })
      if (response.ok) {
        setNewTask('')
        fetchTasks()
      }
    } catch (error) {
      console.error('Error adding task:', error)
    }
  }

  const deleteTask = async (id) => {
    try {
      const response = await fetch(`${API_URL}/${id}`, { method: 'DELETE' })
      if (response.ok) {
        fetchTasks()
      }
    } catch (error) {
      console.error('Error deleting task:', error)
    }
  }

  return (
    <div className="glass-card">
      <h1>Task Manager</h1>
      
      <form onSubmit={addTask} className="input-group">
        <input
          type="text"
          placeholder="What needs to be done?"
          value={newTask}
          onChange={(e) => setNewTask(e.target.value)}
        />
        <button type="submit" className="primary">Add Task</button>
      </form>

      {loading ? (
        <p style={{ textAlign: 'center', color: 'var(--text-secondary)' }}>Loading tasks...</p>
      ) : (
        <ul className="task-list">
          {tasks.map(task => (
            <li key={task.id} className="task-item">
              <span className="task-content">{task.title}</span>
              <button 
                onClick={() => deleteTask(task.id)} 
                className="btn-delete"
                title="Delete task"
              >
                <TrashIcon />
              </button>
            </li>
          ))}
          {tasks.length === 0 && (
            <p style={{ textAlign: 'center', color: 'var(--text-secondary)', marginTop: '1rem' }}>
              No tasks yet. Add one above!
            </p>
          )}
        </ul>
      )}
    </div>
  )
}

function TrashIcon() {
  return (
    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
      <path d="M3 6h18m-2 0v14c0 1-1 2-2 2H7c-1 0-2-1-2-2V6m3 0V4c0-1 1-2 2-2h4c1 0 2 1 2 2v2m-6 9v-4m4 4v-4" />
    </svg>
  )
}

export default App
