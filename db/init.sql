CREATE TABLE IF NOT EXISTS cursos (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      nombre VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS estudiantes (
                                           id INT AUTO_INCREMENT PRIMARY KEY,
                                           nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    edad INT,
    curso_id INT,
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
    );