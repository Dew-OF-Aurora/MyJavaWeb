import React from 'react';

class Test extends React.Component {
  state = {
    message: '这一条信息',
  };
  inputChange = e => {
    this.setState({
      message: e.target.value,
    });
  };
  render() {
    return (
      <>
        {/* 实际上这个回调函数inputChange不需要这样调用，直接{this.inputChange}就行了 */}
        <input type="text" value={this.state.message} onChange={e => this.inputChange(e)}></input>
        <div>{this.state.message}</div>
      </>
    );
  }
}
function ControlledComponents() {
  return <Test></Test>;
}
export default ControlledComponents;
