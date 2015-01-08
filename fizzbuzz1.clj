(defn fizzbuzz [number]
  (map #(cond
          (and (= 0 (mod % 5)) (= 0 (mod % 3))) "FizzBuzz"
          (= 0 (mod % 3)) "Fizz"
          (= 0 (mod % 5)) "Buzz"
          :else %) (range 1 number)))

(defn divides? [x y]
  (= 0 (mod y x)))

(defn fizzbuzz2 [number]
  (map #(cond
          (and (divides? 3 %) (divides? 5 %)) "FizzBuzz"
          (divides? 3 %) "Fizz"
          (divides? 5 %) "Buzz"
          :else %)
       (range 1 number)))

(println (fizzbuzz 100))
(println (fizzbuzz2 100))
(println (count (filter #(= % "FizzBuzz") (fizzbuzz 1000))))
(println (count (filter #(= % "Fizz") (fizzbuzz 1000))))
(println (count (filter #(= % "Buzz") (fizzbuzz 1000))))




