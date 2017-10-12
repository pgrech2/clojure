(ns clojure-practice.brave-true.chpt7)

(def order-of-operations '(- + * /))

(defn pop1
  [coll]
  [(first coll) (rest coll)])

(defn pop2
  [coll]
  [(first coll) (second coll) (rest coll)])

(defn operator?
  [o]
  (some #(= o %) order-of-operations))

(defn greater?
  [o1 o2]
  (when (> (.indexOf order-of-operations o1)
           (.indexOf order-of-operations o2))
    true))

(defn insert
  [state next-ops]
  (if-not (empty? state)
    (list (first next-ops) state (last next-ops))
    next-ops))

(defn wrap
  [state next-ops]
  (if-not (empty? state)
    (list (first state) next-ops (second state))
    next-ops))

(defn syntax-tree
  [operators operands]
  (loop [opt         operators
         opd         operands
         prev-opt    nil
         infix-state (list)]
    (if (not-empty opt)
      (let [[next-opt rest-opt]    (pop1 opt)
            [f-opd s-opd rest-opd] (pop2 opd)
            next-state (list next-opt f-opd s-opd)]
        (recur rest-opt rest-opd next-opt
         (if (greater? next-opt prev-opt)
           (wrap infix-state next-state)
           (insert infix-state next-state))))
      infix-state)))


(defmacro calculate
  [formula]
  (loop [operators (list)
         operands  (list)
         form      formula]
    (if (not-empty form)
      (let [[next-op rest-op] (pop1 form)]
        (if (operator? next-op)
          (recur (conj operators next-op) operands rest-op)
          (recur operators (conj operands next-op) rest-op)))
      (syntax-tree (reverse operators) (reverse operands)))))

;; (macroexpand '(calculate (1 + 3 * 4 - 2)))
