/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p071;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuana
 */
public class DoFile {

    public static void writeToFile(String fileName, ArrayList<Task> listTask) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Task task : listTask) {
                String taskString = String.format("%-5s|%-15s|%-10s|%-10s|%-5s|%-5s|%-15s|%-15s",
                        task.getID(), task.getRequirementName(), task.getTaskType(task.getTaskTypeID()),
                        task.getFormattedDate(), task.getPlanFrom(), task.getPlanTo(), task.getAssignee(), task.getReviewer());
                bufferedWriter.write(taskString);
                bufferedWriter.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    public static ArrayList<Task> readToFile(String fileName, ArrayList<Task> list) {
        File file = new File(fileName);
        //check file exist
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                //read all information
                if (line != null) {
                    String[] data = line.split("[|]");//\\s+: many space
                    int id = Integer.parseInt(data[0].trim());
                    String requirementName = data[1].trim();
                    String taskTypeString = data[2].trim();
                    int taskType;
                    if (taskTypeString.trim().equals("Code")) {
                        taskType = 1;
                    } else if (taskTypeString.trim().equals("Test")) {
                        taskType = 2;
                    } else if (taskTypeString.trim().equals("Design")) {
                        taskType = 3;
                    } else {
                        taskType = 4;
                    }
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = null;
                    try {
                        date = dateFormat.parse(data[3].trim());
                    } catch (ParseException ex) {
                        Logger.getLogger(DoFile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    double from = Double.parseDouble(data[4].trim());
                    double to = Double.parseDouble(data[5].trim());
                    String assignee = data[6].trim();
                    String reviewer = data[7].trim();

                    Task task = new Task(id, requirementName, taskType, date, from, to, assignee, reviewer);
                    list.add(task);
                } else {
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ex) {
            }
        }
        return list;
    }

    public static int getIDFromFile() {
        File file = new File("Id.txt");
        //check file exist
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("Id.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            if (line != null) {
                return Integer.parseInt(line);
            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ex) {
            }
        }
        return 1;
    }

    static void saveIDFromFile(int id) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter("Id.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            id++;
            bufferedWriter.write(id + "");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
            }
        }
    }

}