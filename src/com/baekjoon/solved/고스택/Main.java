package com.baekjoon.solved.고스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    static Stack<Long> stack;
    static boolean error;

    static ArrayList<String> commands;

    static void num(long x) {
        stack.push(x);
    }

    static void pop() {
        if(stack.empty()) error = true;
        else {
            stack.pop();
        }
    }

    static void inv() {
        if(stack.empty()) error = true;
        else {
            long item = stack.pop();
            stack.push(-item);
        }
    }

    static void dup() {
        if(stack.empty()) error = true;
        else {
            long item = stack.pop();
            stack.push(item);
            stack.push(item);
        }
    }

    static void swap() {
        if(stack.empty() || stack.size() == 1) error = true;
        else {
            long firstItem = stack.pop();
            long secondItem = stack.pop();
            stack.push(firstItem);
            stack.push(secondItem);
        }
    }

    static void add() {
        if(stack.empty() || stack.size() == 1) error = true;
        else {
            long firstItem = stack.pop();
            long secondItem = stack.pop();
            if(Math.abs(firstItem + secondItem) > (int)1e9) error = true;
            else stack.push(firstItem + secondItem);
        }
    }

    static void sub() {
        if(stack.empty() || stack.size() == 1) error = true;
        else {
            long firstItem = stack.pop();
            long secondItem = stack.pop();
            if(Math.abs(secondItem - firstItem) > (int)1e9) error = true;
            stack.push(secondItem - firstItem);
        }
    }

    static void mul() {
        if(stack.empty() || stack.size() == 1) error = true;
        else {
            long firstItem = stack.pop();
            long secondItem = stack.pop();
            if(Math.abs(secondItem * firstItem) > (int)1e9) error = true;
            stack.push(secondItem * firstItem);
        }
    }

    static void div() {
        if(stack.empty() || stack.size() == 1) error = true;
        else {
            long firstItem = stack.pop();
            long secondItem = stack.pop();
            if(firstItem == 0) error = true;
            else {
                if(secondItem == 0) stack.push(0L);
                else if ((secondItem < 0 && firstItem < 0) || (secondItem > 0 && firstItem > 0)) {
                    stack.push(Math.abs(secondItem) / Math.abs(firstItem));
                } else if(secondItem > 0 && firstItem < 0) {
                    stack.push(secondItem / Math.abs(firstItem) * -1);
                } else if(secondItem < 0 && firstItem > 0) {
                    stack.push(Math.abs(secondItem) / firstItem * -1);
                }
            }
        }
    }

    static void mod() {
        if(stack.empty() || stack.size() == 1) error = true;
        else {
            long firstItem = stack.pop();
            long secondItem = stack.pop();
            if(firstItem == 0) error = true;
            else{
                if (secondItem == 0) {
                    stack.push(0L);
                } else {
                    if (secondItem < 0) {
                        stack.push(Math.abs(secondItem) % Math.abs(firstItem) * -1);
                    } else {
                        stack.push(Math.abs(secondItem) % Math.abs(firstItem));
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        commands = new ArrayList<>();
        stack = new Stack<>();
        while(true) {
            String[] temp = br.readLine().split(" ");
            // QUIT 처리
            if(temp[0].equals("QUIT")) break;
            // Empty line 처리
            else if(temp[0].equals("")) {
                // 모든 변수 초기화
                error = false;
                commands = new ArrayList<>();
                stack.clear();
                System.out.println();
            } else {
                if(temp[0].equals("END")) {
                    int N = Integer.parseInt(br.readLine());
                    for (int i = 1; i <= N; i++) {
                        stack.clear();
                        error = false;
                        long num = Long.parseLong(br.readLine());
                        stack.push(num);
                        for(int j = 0; j < commands.size();) {
                            String command = commands.get(j);
                            if(command.equals("NUM")) {
                                long number = Long.parseLong(commands.get(j+1));
                                stack.push(number);
                                j +=2;
                            } else {
                                switch(command) {
                                    case "DUP":
                                        dup();
                                        break;
                                    case "POP":
                                        pop();
                                        break;
                                    case "INV":
                                        inv();
                                        break;
                                    case "SWP":
                                        swap();
                                        break;
                                    case "ADD":
                                        add();
                                        break;
                                    case "SUB":
                                        sub();
                                        break;
                                    case "MUL":
                                        mul();
                                        break;
                                    case "DIV":
                                        div();
                                        break;
                                    case "MOD":
                                        mod();
                                        break;
                                }
                                j++;
                            }
                            if(error == true) {
                                System.out.println("ERROR");
                                break;
                            }
                        }
                        if(stack.size() != 1){
                            if(error == false) {
                                System.out.println("ERROR");
                            }
                        } else if(error == true) {
                            continue;
                        }
                        else System.out.println(stack.pop());
                    }
                }
                commands.add(temp[0]);
                if(temp[0].equals("NUM")) {
                    commands.add(temp[1]);
                }


            }


        }
    }
}
