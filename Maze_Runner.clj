(def maze [[1 1 1 1 1 1 1]
           [1 0 0 0 0 0 3]
           [1 0 1 0 1 0 1]
           [0 0 1 0 0 0 1]
           [1 0 1 0 1 0 1]
           [1 0 0 0 0 0 0]
           [1 2 1 0 1 0 1]])
(println "Du befindest dich in einem Labyrinth. X zeigt dir immer an wo du dich befindest. \n\n0 => Safe place to walk | 1 => Wall | 2 => Start Point | 3 => Finish point \nGehe immer in die Himmelsrichtungen. N => Norden | O => Osten | S = Süden | W = Westen \n\nFindest du ins Ziel?\n\n\n")

(defn go_into_maze [maze y x]
  (if(or(> y (- (count maze) 1))(< y 0)(< x 0)(> x (- (count (get maze 0)) 1))) (println "Hier kannst du nicht lang gehen. GAME OVER."))
  (if(=(get(get maze y)x)1) (println "Du bist gegen eine Wand gelaufen. GAME OVER"))
  (if(=(get(get maze y)x)3) (println "Glückwunsch, du hast das Ziel erreicht. YOU WON THIS GAME"))
  (if(or(=(get(get maze y)x)0)(=(get(get maze y)x)2)) 
    (do
      (println "\nDeine aktuelle Position:")
      (run! println (assoc maze y (assoc (get maze y) x "X")))
      (println "\nIn welche Richtung willst du gehen?")
      (case (read-line)
        "N" (do(println "Du gehst einen Schritt in Richtung Norden.")(go_into_maze maze (- y 1) x))
        "O" (do(println "Du gehst einen Schritt in Richtung Osten.")(go_into_maze maze y (+ x 1)))
        "S" (do(println "Du gehst einen Schritt in Richtung Süden.")(go_into_maze maze (+ y 1) x))
        "W" (do(println "Du gehst einen Schritt in Richtung Westen.")(go_into_maze maze y (- x 1)))
      )))     
)

(go_into_maze maze 6 1)
