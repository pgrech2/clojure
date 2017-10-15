(ns clojure-practice.brave-true.chpt4)

;;------------------------------------------
;; THE MAP FUNCTION
(defn titleize
  "This is a function to practice map and reduce"
  [topic]
  (str topic " For The Brave and True"))

;; (map titleize ["Vector1" "Vector2"])
;; (map titleize '("List1" "List2"))
;; (map titleize #{"Map1" "Map2"})
;; (map #(titleize (second %)) {:uncomfortable-thing "Winking"})

(def var1 [0.5 0.6 0.32])
(def var2 [1.5 1.6 1.32])
(defn unify
  [v1 v2]
  {:v1 v1 :v2 v2})
;; (map unify var1 var2)

(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spider-Man" :real "Peter Parker"}
   {:alias "Santa" :real "Your mom"}
   {:alias "Easter Bunny" :real "Your dad"}])
;; (map :real identities)

(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  "Calculate sum, count and average of a vector"
  [numbers]
  (map #(% numbers) [sum count avg]))
;; sum - anonymous function for calculating total sum of vector
;; avg - anonymous function dividing sum (created above) by count of vector which is a built in function
;; stats - map anonymous function to vector of functions


;; take-while & drop-while examples
(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}
   {:month 5 :day 1 :human 3.7 :critter 3.9}
   {:month 5 :day 2 :human 3.7 :critter 3.6}])

;; Get all data for just march
;; (take-while #(< (:month %) 4) (drop-while #(< (:month %) 2) food-journal))
