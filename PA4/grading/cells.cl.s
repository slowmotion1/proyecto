# start of generated code
  .data
  .align  2
  .globl  class_nameTab
  .globl  Main_protObj
  .globl  Int_protObj
  .globl  String_protObj
  .globl  bool_const0
  .globl  bool_const1
  .globl  _int_tag
  .globl  _bool_tag
  .globl  _string_tag
_int_tag:
  .word   3
_bool_tag:
  .word   4
_string_tag:
  .word   5
  .globl  _MemMgr_TEST
_MemMgr_TEST:
  .word   0
str_const16:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const1
  .byte  0
  .align  2
str_const15:
  .word   5
  .word   6
  .word   String_dispTab
  .word   int_const3
  .ascii  "Main"
  .byte  0
  .align  2
str_const14:
  .word   5
  .word   9
  .word   String_dispTab
  .word   int_const4
  .ascii  "CellularAutomaton"
  .byte  0
  .align  2
str_const13:
  .word   5
  .word   6
  .word   String_dispTab
  .word   int_const5
  .ascii  "String"
  .byte  0
  .align  2
str_const12:
  .word   5
  .word   6
  .word   String_dispTab
  .word   int_const3
  .ascii  "Bool"
  .byte  0
  .align  2
str_const11:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const6
  .ascii  "Int"
  .byte  0
  .align  2
str_const10:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const7
  .ascii  "IO"
  .byte  0
  .align  2
str_const9:
  .word   5
  .word   6
  .word   String_dispTab
  .word   int_const5
  .ascii  "Object"
  .byte  0
  .align  2
str_const8:
  .word   5
  .word   7
  .word   String_dispTab
  .word   int_const8
  .ascii  "_prim_slot"
  .byte  0
  .align  2
str_const7:
  .word   5
  .word   7
  .word   String_dispTab
  .word   int_const9
  .ascii  "SELF_TYPE"
  .byte  0
  .align  2
str_const6:
  .word   5
  .word   7
  .word   String_dispTab
  .word   int_const9
  .ascii  "_no_class"
  .byte  0
  .align  2
str_const5:
  .word   5
  .word   8
  .word   String_dispTab
  .word   int_const10
  .ascii  "<basic class>"
  .byte  0
  .align  2
str_const4:
  .word   5
  .word   9
  .word   String_dispTab
  .word   int_const11
  .ascii  "         X         "
  .byte  0
  .align  2
str_const3:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const0
  .ascii  "."
  .byte  0
  .align  2
str_const2:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const0
  .ascii  "X"
  .byte  0
  .align  2
str_const1:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const0
  .ascii  "\n"
  .byte  0
  .align  2
str_const0:
  .word   5
  .word   9
  .word   String_dispTab
  .word   int_const12
  .ascii  "grading/cells.cl"
  .byte  0
  .align  2
int_const12:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   16
int_const11:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   19
int_const10:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   13
int_const9:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   9
int_const8:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   10
int_const7:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   2
int_const6:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   3
int_const5:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   6
int_const4:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   17
int_const3:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   4
int_const2:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   20
int_const1:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   0
int_const0:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   1
bool_const0:
  .word   4
  .word   4
  .word   Bool_dispTab
  .word   0
bool_const1:
  .word   4
  .word   4
  .word   Bool_dispTab
  .word   1
class_nameTab:
  .word   str_const9
  .word   str_const10
  .word   str_const14
  .word   str_const11
  .word   str_const12
  .word   str_const13
  .word   str_const15
class_objTab:
  .word   Object_protObj
  .word   Object_init
  .word   IO_protObj
  .word   IO_init
  .word   CellularAutomaton_protObj
  .word   CellularAutomaton_init
  .word   Int_protObj
  .word   Int_init
  .word   Bool_protObj
  .word   Bool_init
  .word   String_protObj
  .word   String_init
  .word   Main_protObj
  .word   Main_init
Object_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
IO_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   IO.out_string
  .word   IO.out_int
  .word   IO.in_string
  .word   IO.in_int
CellularAutomaton_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   IO.out_string
  .word   IO.out_int
  .word   IO.in_string
  .word   IO.in_int
  .word   CellularAutomaton.init
  .word   CellularAutomaton.print
  .word   CellularAutomaton.num_cells
  .word   CellularAutomaton.cell
  .word   CellularAutomaton.cell_left_neighbor
  .word   CellularAutomaton.cell_right_neighbor
  .word   CellularAutomaton.cell_at_next_evolution
  .word   CellularAutomaton.evolve
Int_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
Bool_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
String_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   String.length
  .word   String.concat
  .word   String.substr
Main_dispTab:
  .word   Object.abort
  .word   Object.type_name
  .word   Object.copy
  .word   Main.main
  .word   -1
Object_protObj:
  .word   0
  .word   3
  .word   Object_dispTab
  .word   -1
IO_protObj:
  .word   1
  .word   3
  .word   IO_dispTab
  .word   -1
CellularAutomaton_protObj:
  .word   2
  .word   4
  .word   CellularAutomaton_dispTab
  .word   str_const16
  .word   -1
Int_protObj:
  .word   3
  .word   4
  .word   Int_dispTab
  .word   0
  .word   -1
Bool_protObj:
  .word   4
  .word   4
  .word   Bool_dispTab
  .word   0
  .word   -1
String_protObj:
  .word   5
  .word   5
  .word   String_dispTab
  .word   int_const1
  .word   0
  .word   -1
Main_protObj:
  .word   6
  .word   4
  .word   Main_dispTab
  .word   0
  .globl  heap_start
heap_start:
  .word   0
  .text
  .globl  Main_init
  .globl  Int_init
  .globl  String_init
  .globl  Bool_init
  .globl  Main.main
Object_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
IO_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Object_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
CellularAutomaton_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   IO_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
Int_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Object_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
Bool_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Object_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
String_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Object_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
Main_init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  jal   Object_init
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
CellularAutomaton.init:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  lw    a0 12(tp)
  sw    a0 12(s0)
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 16
  ret   
CellularAutomaton.print:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  la    a0 str_const1
  sw    a0 0(sp)
  addi  sp sp -4
  lw    a0 12(s0)
  bne   a0 x0 label0
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label0:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label1
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label1:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
CellularAutomaton.num_cells:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  lw    a0 12(s0)
  bne   a0 x0 label2
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label2:
  lw    t1 8(a0)
  lw    t1 12(t1)
  jalr  t1
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 12
  ret   
CellularAutomaton.cell:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 int_const0
  sw    a0 0(sp)
  addi  sp sp -4
  lw    a0 12(s0)
  bne   a0 x0 label3
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label3:
  lw    t1 8(a0)
  lw    t1 20(t1)
  jalr  t1
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 16
  ret   
CellularAutomaton.cell_left_neighbor:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 int_const1
  lw    t1 4(sp)
  addi  sp sp 4
  mv    t2 a0
  la    a0 bool_const1
  beq   t1 t2 label4
  la    a1 bool_const0
  jal   equality_test
label4:
  lw    t1 12(a0)
  beqz  t1 label5
  mv    a0 s0
  bne   a0 x0 label7
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label7:
  lw    t1 8(a0)
  lw    t1 36(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 int_const0
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  sub   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label8
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label8:
  lw    t1 8(a0)
  lw    t1 40(t1)
  jalr  t1
  j     label6
label5:
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 int_const0
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  sub   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label9
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label9:
  lw    t1 8(a0)
  lw    t1 40(t1)
  jalr  t1
label6:
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 16
  ret   
CellularAutomaton.cell_right_neighbor:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label11
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label11:
  lw    t1 8(a0)
  lw    t1 36(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 int_const0
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  sub   t1 t1 t2
  sw    t1 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  mv    t2 a0
  la    a0 bool_const1
  beq   t1 t2 label10
  la    a1 bool_const0
  jal   equality_test
label10:
  lw    t1 12(a0)
  beqz  t1 label12
  la    a0 int_const1
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label14
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label14:
  lw    t1 8(a0)
  lw    t1 40(t1)
  jalr  t1
  j     label13
label12:
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 int_const0
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label15
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label15:
  lw    t1 8(a0)
  lw    t1 40(t1)
  jalr  t1
label13:
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 16
  ret   
CellularAutomaton.cell_at_next_evolution:
  addi  sp sp -12
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label18
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label18:
  lw    t1 8(a0)
  lw    t1 40(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 str_const2
  lw    t1 4(sp)
  addi  sp sp 4
  mv    t2 a0
  la    a0 bool_const1
  beq   t1 t2 label17
  la    a1 bool_const0
  jal   equality_test
label17:
  lw    t1 12(a0)
  beqz  t1 label19
  la    a0 int_const0
  j     label20
label19:
  la    a0 int_const1
label20:
  sw    a0 0(sp)
  addi  sp sp -4
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label22
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label22:
  lw    t1 8(a0)
  lw    t1 44(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 str_const2
  lw    t1 4(sp)
  addi  sp sp 4
  mv    t2 a0
  la    a0 bool_const1
  beq   t1 t2 label21
  la    a1 bool_const0
  jal   equality_test
label21:
  lw    t1 12(a0)
  beqz  t1 label23
  la    a0 int_const0
  j     label24
label23:
  la    a0 int_const1
label24:
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label26
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label26:
  lw    t1 8(a0)
  lw    t1 48(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 str_const2
  lw    t1 4(sp)
  addi  sp sp 4
  mv    t2 a0
  la    a0 bool_const1
  beq   t1 t2 label25
  la    a1 bool_const0
  jal   equality_test
label25:
  lw    t1 12(a0)
  beqz  t1 label27
  la    a0 int_const0
  j     label28
label27:
  la    a0 int_const1
label28:
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 int_const0
  lw    t1 4(sp)
  addi  sp sp 4
  mv    t2 a0
  la    a0 bool_const1
  beq   t1 t2 label16
  la    a1 bool_const0
  jal   equality_test
label16:
  lw    t1 12(a0)
  beqz  t1 label29
  la    a0 str_const2
  j     label30
label29:
  la    a0 str_const3
label30:
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 16
  ret   
CellularAutomaton.evolve:
  addi  sp sp -24
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  la    a0 int_const1
  sw    a0 12(tp)
  mv    a0 s0
  bne   a0 x0 label31
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label31:
  lw    t1 8(a0)
  lw    t1 36(t1)
  jalr  t1
  sw    a0 16(tp)
  la    a0 str_const16
  sw    a0 20(tp)
label32:
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  lw    a0 16(tp)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  lw    t2 12(a0)
  la    a0 bool_const1
  blt   t1 t2 label34
  la    a0 bool_const0
label34:
  lw    t1 12(a0)
  beq   t1 x0 label33
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  mv    a0 s0
  bne   a0 x0 label35
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label35:
  lw    t1 8(a0)
  lw    t1 52(t1)
  jalr  t1
  sw    a0 0(sp)
  addi  sp sp -4
  lw    a0 20(tp)
  bne   a0 x0 label36
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label36:
  lw    t1 8(a0)
  lw    t1 16(t1)
  jalr  t1
  sw    a0 20(tp)
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 int_const0
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  add   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 12(tp)
  j     label32
label33:
  mv    a0 x0
  lw    a0 20(tp)
  sw    a0 12(s0)
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 24
  ret   
Main.main:
  addi  sp sp -16
  sw    tp 12(sp)
  sw    s0 8(sp)
  sw    ra 4(sp)
  addi  tp sp 4
  mv    s0 a0
  la    a0 str_const4
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 CellularAutomaton_protObj
  jal   Object.copy
  jal   CellularAutomaton_init
  bne   a0 x0 label37
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label37:
  lw    t1 8(a0)
  lw    t1 28(t1)
  jalr  t1
  sw    a0 12(s0)
  lw    a0 12(s0)
  bne   a0 x0 label38
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label38:
  lw    t1 8(a0)
  lw    t1 32(t1)
  jalr  t1
  la    a0 int_const2
  sw    a0 12(tp)
label39:
  la    a0 int_const1
  sw    a0 0(sp)
  addi  sp sp -4
  lw    a0 12(tp)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  lw    t2 12(a0)
  la    a0 bool_const1
  blt   t1 t2 label41
  la    a0 bool_const0
label41:
  lw    t1 12(a0)
  beq   t1 x0 label40
  lw    a0 12(s0)
  bne   a0 x0 label42
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label42:
  lw    t1 8(a0)
  lw    t1 56(t1)
  jalr  t1
  lw    a0 12(s0)
  bne   a0 x0 label43
  la    a0 str_const0
  li    t1 1
  jal   _dispatch_abort
label43:
  lw    t1 8(a0)
  lw    t1 32(t1)
  jalr  t1
  lw    a0 12(tp)
  sw    a0 0(sp)
  addi  sp sp -4
  la    a0 int_const0
  jal   Object.copy
  lw    t2 12(a0)
  lw    t1 4(sp)
  addi  sp sp 4
  lw    t1 12(t1)
  sub   t1 t1 t2
  sw    t1 12(a0)
  sw    a0 12(tp)
  j     label39
label40:
  mv    a0 x0
  mv    a0 s0
  lw    tp 12(sp)
  lw    s0 8(sp)
  lw    ra 4(sp)
  addi  sp sp 16
  ret   

# end of generated code
