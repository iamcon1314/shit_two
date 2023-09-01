  .text
  .globl gbzs
gbzs:
.L0:
  li t0, -36
  null sp, sp, t0
  sw ra, 0(sp)
  li t0, 4
  null t0, sp, t0
  sw t0, 16(sp)
  li t0, 8
  null t0, sp, t0
  sw t0, 20(sp)
  li t0, 12
  null t0, sp, t0
  sw t0, 24(sp)
  lw t1, 16(sp)
  sw a0, 0(t1)
  lw t1, 20(sp)
  sw a1, 0(t1)
  lw t1, 20(sp)
  lw t0, 0(t1)
  sw t0, 28(sp)
  lw t1, 24(sp)
  lw t0, 28(sp)
  sw t0, 0(t1)
  j .L1
.L1:
  lw t1, 24(sp)
  lw t0, 0(t1)
  sw t0, 32(sp)
  lw t1, 32(sp)
  mv a0, t1
  lw ra, 0(sp)
  li t0, 36
  null sp, sp, t0
  ret
  .text
  .globl main
main:
.L2:
  li t0, -20
  null sp, sp, t0
  sw ra, 0(sp)
  li t0, 4
  null t0, sp, t0
  sw t0, 8(sp)
  li t1, 4
  mv a0, t1
  li t1, 8
  mv a1, t1
  call gbzs
  mv t0, a0
  sw t0, 12(sp)
  lw t1, 8(sp)
  li t0, 0
  sw t0, 0(t1)
  j .L3
.L3:
  lw t1, 8(sp)
  lw t0, 0(t1)
  sw t0, 16(sp)
  lw t1, 16(sp)
  mv a0, t1
  lw ra, 0(sp)
  li t0, 20
  null sp, sp, t0
  ret
