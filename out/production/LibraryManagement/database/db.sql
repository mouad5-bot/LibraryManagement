CREATE DATABASE library_management;
USE library_management;

CREATE TABLE Book (
                      isbn VARCHAR(20) NOT NULL PRIMARY KEY,
                      title VARCHAR(100) NOT NULL,
                      idAuthor INT NOT NULL,
                      stateOfBook VARCHAR(20) NOT NULL CHECK (stateOfBook = 'available' OR stateOfBook = 'unavailable'),
                      quantity INT,
                      quantityBorrowed INT,
                      quantityAvailable INT,
                      quantityLost INT
);

CREATE TABLE Person (
                        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(30) NOT NULL
);

CREATE TABLE Borrower (
                          id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          FOREIGN KEY (id) REFERENCES Person(id)
);

CREATE TABLE Librarians (
                            id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            FOREIGN KEY (id) REFERENCES Person(id)
);

CREATE TABLE Author (
                        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        FOREIGN KEY (id) REFERENCES Person(id)
);

CREATE TABLE Reservation (
                             id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             idBorrower INT NOT NULL,
                             idBook VARCHAR(20) NOT NULL,
                             dateReservation DATE NOT NULL,
                             dateReturn DATE NOT NULL,
                             FOREIGN KEY (idBorrower) REFERENCES Borrower(id),
                             FOREIGN KEY (idBook) REFERENCES Book(isbn)
);