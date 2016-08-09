(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "my name is paul"))

(defn -main2
  "I don't do a whole lot ... yet."
  [& args]
  (println "my name is paul in main 2"))


(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity "mild")
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOMED!")))


(defn what-is-a-docstring
  "This is a docstring, it is used for documenting and describing a function"
  [& args]
  (println "Docstring function"))

(defn no-param
  "0-arity function: This is a function without parameters"
  []
  (println "No Parameters"))


(defn one-param
  "1-arity function: This is a function with one parameter"
  [parameter]
  (str "This is the parameter: " parameter))

(defn two-param
  "2-arity function: This is a function with two parameters"
  [parameter1 parameter2]
  (str "Parameter SMOOOOOOSHHHH: " parameter1 parameter2))


(defn multi-arity
  "Multiple arity function"
  ;; 3-arity arguments and body
  ([first-arg second-arg third-arg]
   (str "Three arguments: " first-arg " " second-arg " " third-arg))
  ;; 2-arity arguments and body
  ([first-arg second-arg]
   (str "Two arguments: " first-arg " " second-arg))
  ;; 1-arity arguments and body
  ([first-arg]
   (str "One argument: " first-arg)))


(defn overloading
  "Example for default function arguments"
  ([arg1 arg2]
   (str "This is argument 1 & 2: " arg1 " " arg2))
  ([arg1]
   (overloading arg1 "default")))


(defn other-arity
  "Example with two different function bodies"
  ([]
   (println "Functional Body 1"))
  ([number] (inc number)))


(defn base-func
  [response]
  (str "Hello, " response))

(defn rest-function
  "Example of a function with a rest parameter"
  [& rest-parameter]
  (map base-func rest-parameter))