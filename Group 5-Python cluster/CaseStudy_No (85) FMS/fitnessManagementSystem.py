import mysql.connector
from mysql.connector import Error
import datetime

class Membership:
    def __init__(self, membership_id, member_name, member_contact, membership_type, membership_expiry):
        self.membership_id = membership_id
        self.member_name = member_name
        self.member_contact = member_contact
        self.membership_type = membership_type
        self.membership_expiry = membership_expiry

class Trainer:
    def __init__(self, trainer_id, name, specialty, contact_info, availability):
        self.trainer_id = trainer_id
        self.name = name
        self.specialty = specialty
        self.contact_info = contact_info
        self.availability = availability

class FitnessClass:
    def __init__(self, class_id, class_name, trainer_id, schedule, capacity):
        self.class_id = class_id
        self.class_name = class_name
        self.trainer_id = trainer_id
        self.schedule = schedule
        self.capacity = capacity

class Attendance:
    def __init__(self, attendance_id, member_id, class_id, attendance_date):
        self.attendance_id = attendance_id
        self.member_id = member_id
        self.class_id = class_id
        self.attendance_date = attendance_date
        class FitnessCenterManagementSystem:
            def __init__(self):
                self.memberships = {}
                self.trainers = {}
                self.classes = {}
                self.attendances = {}
        

            def add_membership(self, membership):
                if membership.membership_id in self.memberships:
                    raise ValueError("Membership ID already exists.")
                self.memberships[membership.membership_id] = membership
        
            def update_membership(self, membership_id, **kwargs):
                if membership_id not in self.memberships:
                    raise ValueError("Membership ID not found.")
                for key, value in kwargs.items():
                    setattr(self.memberships[membership_id], key, value)
        
            def delete_membership(self, membership_id):
                if membership_id not in self.memberships:
                    raise ValueError("Membership ID not found.")
                del self.memberships[membership_id]
        

            def add_trainer(self, trainer):
                if trainer.trainer_id in self.trainers:
                    raise ValueError("Trainer ID already exists.")
                self.trainers[trainer.trainer_id] = trainer
        
            def update_trainer(self, trainer_id, **kwargs):
                if trainer_id not in self.trainers:
                    raise ValueError("Trainer ID not found.")
                for key, value in kwargs.items():
                    setattr(self.trainers[trainer_id], key, value)
        
            def delete_trainer(self, trainer_id):
                if trainer_id not in self.trainers:
                    raise ValueError("Trainer ID not found.")
                del self.trainers[trainer_id]
        

            def add_class(self, fitness_class):
                if fitness_class.class_id in self.classes:
                    raise ValueError("Class ID already exists.")
                self.classes[fitness_class.class_id] = fitness_class
        
            def update_class(self, class_id, **kwargs):
                if class_id not in self.classes:
                    raise ValueError("Class ID not found.")
                for key, value in kwargs.items():
                    setattr(self.classes[class_id], key, value)
        
            def delete_class(self, class_id):
                if class_id not in self.classes:
                    raise ValueError("Class ID not found.")
                del self.classes[class_id]
        

            def add_attendance(self, attendance):
                if attendance.attendance_id in self.attendances:
                    raise ValueError("Attendance ID already exists.")
                self.attendances[attendance.attendance_id] = attendance
        
            def update_attendance(self, attendance_id, **kwargs):
                if attendance_id not in self.attendances:
                    raise ValueError("Attendance ID not found.")
                for key, value in kwargs.items():
                    setattr(self.attendances[attendance_id], key, value)
        
            def delete_attendance(self, attendance_id):
                if attendance_id not in self.attendances:
                    raise ValueError("Attendance ID not found.")
                del self.attendances[attendance_id]
# 

def create_connection():
    try:
        connection = mysql.connector.connect(
            host='localhost',
            database='fitness_center',
            user='root',
            password=''
        )
        if connection.is_connected():
            print("Connected to MySQL database")
        return connection
    except Error as e:
        print(f"Error: {e}")
        return None
# 
class FitnessCenterManagementSystem:
    def __init__(self):
        self.connection = create_connection()

    def __del__(self):
        if self.connection.is_connected():
            self.connection.close()

    # Membership management
    def add_membership(self, membership):
        cursor = self.connection.cursor()
        query = "INSERT INTO Memberships (member_name, member_contact, membership_type, membership_expiry) VALUES (%s, %s, %s, %s)"
        cursor.execute(query, (membership.member_name, membership.member_contact, membership.membership_type, membership.membership_expiry))
        self.connection.commit()

    def update_membership(self, membership_id, **kwargs):
        cursor = self.connection.cursor()
        set_clause = ", ".join([f"{key} = %s" for key in kwargs.keys()])
        values = list(kwargs.values()) + [membership_id]
        query = f"UPDATE Memberships SET {set_clause} WHERE membership_id = %s"
        cursor.execute(query, values)
        self.connection.commit()

    def delete_membership(self, membership_id):
        cursor = self.connection.cursor()
        query = "DELETE FROM Memberships WHERE membership_id = %s"
        cursor.execute(query, (membership_id,))
        self.connection.commit()

    # Trainer management
    def add_trainer(self, trainer):
        cursor = self.connection.cursor()
        query = "INSERT INTO Trainers (name, specialty, contact_info, availability) VALUES (%s, %s, %s, %s)"
        cursor.execute(query, (trainer.name, trainer.specialty, trainer.contact_info, trainer.availability))
        self.connection.commit()

    def update_trainer(self, trainer_id, **kwargs):
        cursor = self.connection.cursor()
        set_clause = ", ".join([f"{key} = %s" for key in kwargs.keys()])
        values = list(kwargs.values()) + [trainer_id]
        query = f"UPDATE Trainers SET {set_clause} WHERE trainer_id = %s"
        cursor.execute(query, values)
        self.connection.commit()

    def delete_trainer(self, trainer_id):
        cursor = self.connection.cursor()
        query = "DELETE FROM Trainers WHERE trainer_id = %s"
        cursor.execute(query, (trainer_id,))
        self.connection.commit()


    def add_class(self, fitness_class):
        cursor = self.connection.cursor()
        query = "INSERT INTO Classes (class_name, trainer_id, schedule, capacity) VALUES (%s, %s, %s, %s)"
        cursor.execute(query, (fitness_class.class_name, fitness_class.trainer_id, fitness_class.schedule, fitness_class.capacity))
        self.connection.commit()

    def update_class(self, class_id, **kwargs):
        cursor = self.connection.cursor()
        set_clause = ", ".join([f"{key} = %s" for key in kwargs.keys()])
        values = list(kwargs.values()) + [class_id]
        query = f"UPDATE Classes SET {set_clause} WHERE class_id = %s"
        cursor.execute(query, values)
        self.connection.commit()

    def delete_class(self, class_id):
        cursor = self.connection.cursor()
        query = "DELETE FROM Classes WHERE class_id = %s"
        cursor.execute(query, (class_id,))
        self.connection.commit()


    def add_attendance(self, attendance):
        cursor = self.connection.cursor()
        query = "INSERT INTO Attendance (member_id, class_id, attendance_date) VALUES (%s, %s, %s)"
        cursor.execute(query, (attendance.member_id, attendance.class_id, attendance.attendance_date))
        self.connection.commit()

    def update_attendance(self, attendance_id, **kwargs):
        cursor = self.connection.cursor()
        set_clause = ", ".join([f"{key} = %s" for key in kwargs.keys()])
        values = list(kwargs.values()) + [attendance_id]
        query = f"UPDATE Attendance SET {set_clause} WHERE attendance_id = %s"
        cursor.execute(query, values)
        self.connection.commit()

    def delete_attendance(self, attendance_id):
        cursor = self.connection.cursor()
        query = "DELETE FROM Attendance WHERE attendance_id = %s"
        cursor.execute(query, (attendance_id,))
        self.connection.commit()

def main():
    system = FitnessCenterManagementSystem()

    while True:
        print("\nFitness Center Management System")
        print("1. Add Membership")
        print("2. Update Membership")
        print("3. Delete Membership")
        print("4. Add Trainer")
        print("5. Update Trainer")
        print("6. Delete Trainer")
        print("7. Add Class")
        print("8. Update Class")
        print("9. Delete Class")
        print("10. Add Attendance")
        print("11. Update Attendance")
        print("12. Delete Attendance")
        print("13. Exit")

        choice = input("Enter your choice: ")

        try:
            if choice == '1':
                member_name = input("Enter Member Name: ")
                member_contact = input("Enter Member Contact: ")
                membership_type = input("Enter Membership Type: ")
                membership_expiry = input("Enter Membership Expiry (YYYY-MM-DD): ")
                membership_expiry = datetime.datetime.strptime(membership_expiry, "%Y-%m-%d")
                membership = Membership(None, member_name, member_contact, membership_type, membership_expiry)
                system.add_membership(membership)
                print("Membership added successfully.")

            elif choice == '2':
                membership_id = input("Enter Membership ID to update: ")
                member_name = input("Enter Member Name: ")
                member_contact = input("Enter Member Contact: ")
                membership_type = input("Enter Membership Type: ")
                membership_expiry = input("Enter Membership Expiry (YYYY-MM-DD): ")
                membership_expiry = datetime.datetime.strptime(membership_expiry, "%Y-%m-%d")
                system.update_membership(membership_id, member_name=member_name, member_contact=member_contact, membership_type=membership_type, membership_expiry=membership_expiry)
                print("Membership updated successfully.")

            elif choice == '3':
                membership_id = input("Enter Membership ID to delete: ")
                system.delete_membership(membership_id)
                print("Membership deleted successfully.")

            elif choice == '4':
                name = input("Enter Trainer Name: ")
                specialty = input("Enter Trainer Specialty: ")
                contact_info = input("Enter Trainer Contact Info: ")
                availability = input("Enter Trainer Availability: ")
                trainer = Trainer(None, name, specialty, contact_info, availability)
                system.add_trainer(trainer)
                print("Trainer added successfully.")

            elif choice == '5':
                trainer_id = input("Enter Trainer ID to update: ")
                name = input("Enter Trainer Name: ")
                specialty = input("Enter Trainer Specialty: ")
                contact_info = input("Enter Trainer Contact Info: ")
                availability = input("Enter Trainer Availability: ")
                system.update_trainer(trainer_id, name=name, specialty=specialty, contact_info=contact_info, availability=availability)
                print("Trainer updated successfully.")
            elif choice == '6':
                trainer_id = input("Enter Trainer ID to delete: ")
                system.delete_trainer(trainer_id)
                print("Trainer deleted successfully.")

            elif choice == '7':
                class_name = input("Enter Class Name: ")
                trainer_id = input("Enter Trainer ID: ")
                schedule = input("Enter Class Schedule (YYYY-MM-DD HH:MM:SS): ")
                schedule = datetime.datetime.strptime(schedule, "%Y-%m-%d %H:%M:%S")
                capacity = input("Enter Class Capacity: ")
                fitness_class = FitnessClass(None, class_name, trainer_id, schedule, capacity)
                system.add_class(fitness_class)
                print("Class added successfully.")

            elif choice == '8':
                class_id = input("Enter Class ID to update: ")
                class_name = input("Enter Class Name: ")
                trainer_id = input("Enter Trainer ID: ")
                schedule = input("Enter Class Schedule (YYYY-MM-DD HH:MM:SS): ")
                schedule = datetime.datetime.strptime(schedule, "%Y-%m-%d %H:%M:%S")
                capacity = input("Enter Class Capacity: ")
                system.update_class(class_id, class_name=class_name, trainer_id=trainer_id, schedule=schedule, capacity=capacity)
                print("Class updated successfully.")

            elif choice == '9':
                class_id = input("Enter Class ID to delete: ")
                system.delete_class(class_id)
                print("Class deleted successfully.")

            elif choice == '10':
                member_id = input("Enter Member ID: ")
                class_id = input("Enter Class ID: ")
                attendance_date = input("Enter Attendance Date (YYYY-MM-DD): ")
                attendance_date = datetime.datetime.strptime(attendance_date, "%Y-%m-%d")
                attendance = Attendance(None, member_id, class_id, attendance_date)
                system.add_attendance(attendance)
                print("Attendance added successfully.")

            elif choice == '11':
                attendance_id = input("Enter Attendance ID to update: ")
                member_id = input("Enter Member ID: ")
                class_id = input("Enter Class ID: ")
                attendance_date = input("Enter Attendance Date (YYYY-MM-DD): ")
                attendance_date = datetime.datetime.strptime(attendance_date, "%Y-%m-%d")
                system.update_attendance(attendance_id, member_id=member_id, class_id=class_id, attendance_date=attendance_date)
                print("Attendance updated successfully.")

            elif choice == '12':
                attendance_id = input("Enter Attendance ID to delete: ")
                system.delete_attendance(attendance_id)
                print("Attendance deleted successfully.")

            elif choice == '13':
                print("Exiting...")
                break

            else:
                print("Invalid choice. Please try again.")

        except ValueError as ve:
            print(f"Error: {ve}")

        except Exception as e:
            print(f"An unexpected error occurred: {e}")

if __name__ == "__main__":
    main()
        